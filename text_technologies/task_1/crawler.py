# s0829961
# tts assignment 1

import re
import robotparser
import pylab
import time
import urllib2

# urls
robots_url = "http://ir.inf.ed.ac.uk/robots.txt"
base_url = "http://ir.inf.ed.ac.uk/tts/A1/0829961/"
start_url = "http://ir.inf.ed.ac.uk/tts/A1/0829961/0829961.html"

# information for fetching
user_agent = "TTS"
headers = { 'User-Agent' : user_agent }
crawl_delay = 0

# pages to be crawled
frontier = {"0829961": start_url}

# stat variables
extracted = 0
disallowed = {}
outsidelinks = {}
distinct_links = {"0829961.html": 1}
processed = {}
error_codes = {}

# update a certain stat
def update_stat(stat, item):
  if (item in stat):
    stat[item] += 1
  else:
    stat[item] = 1

def show_allowed():
  x = []
  values = []
  keys = list(processed.keys())

  for i in keys:
    x.append(int(i))
    values.append(processed[i])  

  pylab.bar(x, values)
  pylab.show()

def show_disallowed():
  x = []
  values = []
  keys = list(disallowed.keys())

  for i in keys:
    x.append(int(i[-12:-5]))
    values.append(disallowed[i])  

  pylab.bar(x, values)
  pylab.show()

# start timer
start = time.time()

# retrieve rules from robots.txt
robot = robotparser.RobotFileParser()
robot.set_url(robots_url)
robot.read()

# get crawl delay
robots_request = urllib2.Request(robots_url, None, headers)
robots_rules = urllib2.urlopen(robots_request).read()
robots_delay = re.findall("Crawl-delay: (\d)", robots_rules)
if (robots_delay != []):
  crawl_delay = float(robots_delay[0])

print "Starting crawl"

# while the frontier still has items
while (len(frontier)):
  # get highest priority url
  url_id = sorted(frontier, reverse=True)[0]
  new_url = frontier.pop(url_id)

  # are we allowed to fetch the page
  if (robot.can_fetch(user_agent, new_url)):

    # we are processing so update
    processed[url_id] = 1 

    # retrieve page content
    request = urllib2.Request(new_url, None, headers)
    try: 
      response = urllib2.urlopen(request)

    except urllib2.HTTPError, e:
      # an error has occurred so update error codes stat
      update_stat(error_codes, e.code)   

    else:
      # find content between <!-- CONTENT --> and <!-- /CONTENT --> tags
      content = response.read()
      tag_content = re.findall("<!-- CONTENT -->(.*?)<!-- /CONTENT -->", content, re.DOTALL)

      # is there any content between tags
      if (tag_content != []):
        # find ahref links
        ahref_links = re.findall('<a.*?href="(.*?)"', tag_content[0], re.DOTALL)
        
        # add only new unique local urls to the frontier
        for link in ahref_links:
          # new link may be being added so update distinct links stat
          update_stat(distinct_links, link)
          extracted += 1

          # is link local
          if (not(link.startswith("http"))):
            link_id = link[:-5]
            # has link already been processed
            if (link_id not in processed):

              # is link already in frontier
              if (link_id not in frontier):
                frontier[link_id] =  base_url + link

            # update processed
            else:
              processed[link_id] += 1

          # link not local
          else:
            # not local so update outside links stat
            update_stat(outside_links, link)
      
      # no content
      else:
        # an error has occurred so update error codes stat
        update_stat(error_codes, "200 without content")

    time.sleep(crawl_delay)

  # not allowed to fetch so update disallowed stat  
  else:
    update_stat(disallowed, new_url)

# print out stats
print "STATS"
print "Time taken: {0} seconds".format(time.time() - start)
print "Number of non unique extracted urls: {0}".format(extracted)
print "Number of unique extracted links: {0}".format(len(processed) - 1 + len(outsidelinks))
print "Number of distinct urls: {0}".format(len(distinct_links))
print "Number of fetched pages: {0}".format(len(processed))
print "Number of unique pages disallowed: {0}".format(len(disallowed))
print "Number of errors encountered {0}".format(error_codes)
print "Number of outside links: {0}".format(len(outsidelinks))
