<<<<<<< HEAD
# Stage 1 – REST API Design

## Endpoints

GET /notifications

POST /notifications

PATCH /notifications/{id}/read

DELETE /notifications/{id}

## Request JSON

{
"studentId": 1042,
"type": "Placement",
"message": "New placement drive"
}

## Response JSON

{
"id": "uuid",
"type": "Placement",
"message": "New placement drive",
"timestamp": "2026-06-07T10:00:00Z"
}

## Real Time Notification Mechanism

WebSocket is preferred because it provides real-time bidirectional communication with low latency.

## Error Response

{
"error": "Notification not found"
}

## API Versioning

/api/v1/notifications

# Stage 2 – Database Design

Database: PostgreSQL

Reason:

* Structured data
* ACID compliance
* Efficient indexing

Schema:

notifications

* id
* student_id
* type
* message
* is_read
* created_at

Indexes:

* student_id
* created_at
* (student_id, is_read)

Scaling:

* Read replicas
* Partitioning
* Redis cache

# Stage 3 – Query Optimization

Query:

SELECT *
FROM notifications
WHERE studentID = 1042
AND isRead = false
ORDER BY createdAt DESC;

Optimization:

* Composite index(studentID, isRead, createdAt)
* Avoid SELECT *
* Use pagination

Why indexing every column is bad:

* More storage
* Slower inserts and updates

Placement notifications in last 7 days:

SELECT *
FROM notifications
WHERE type='Placement'
AND createdAt >= NOW() - INTERVAL '7 days';

# Stage 4 – Performance Improvement

Solutions:

* Redis caching
* Pagination
* Lazy loading
* Push notifications
* Database indexing

Tradeoffs:

* Cache consistency issues
* Additional infrastructure cost

# Stage 5 – High Scale Notification Delivery

Problems:

* Sequential processing
* No retries
* Single point of failure

Solution:

* Kafka / RabbitMQ
* Retry queue
* Dead Letter Queue
* Event-driven architecture

Flow:

Producer -> Queue -> Worker -> Email/App/DB

# Stage 6 – Priority Inbox

Priority:

Placement > Result > Event

Approach:

* Priority Queue (Heap)
* Score = Priority Weight + Recency Weight

Complexities:

* Insert: O(log n)
* Remove: O(log n)
* Top N: O(n log n)
=======
# Campus Notification System Design
>>>>>>> 930a8769dedacce7a9e3c62e7b5409c94eb7cd4e
