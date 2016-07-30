/* queue.h
 * Queue for workers ids
 */

typedef struct queue_node_tag queue_node;
typedef struct queue_tag queue;

struct queue_node_tag {
  int     w_id;
  queue_node *next;
	queue_node *prev;
};

struct queue_tag {
  queue_node     *front;
	queue_node     *end;
};


queue *new_queue();
void free_queue(queue *);

void    push_queue(int, queue *);
int     pop_queue (queue *);

int is_empty_q (queue *);

