


[Was ist Pagination ?](https://www.baeldung.com/jpa-pagination)

[Spring Data JPA from 0-100 in 60 minutes
](https://www.youtube.com/watch?v=Zyqpo8gxSO0)
Quick jump

—————     JPA entityManager     —————

- [5:53](https://www.youtube.com/watch?v=Zyqpo8gxSO0&t=353s) @version for optimistic locking
- [9:35](https://www.youtube.com/watch?v=Zyqpo8gxSO0&t=575s) jpa does delayed write to the db, writes as late as possible. Persisting an object to the entityManager doesn’t actually write it in the db as soon as u make the persist call. But when you send a query to the db through the entityManager, then it flushes the writes to the db.
- [12:10](https://www.youtube.com/watch?v=Zyqpo8gxSO0&t=730s) class annotated with @transactional, each methods started and closes a transaction
- [13:30](https://www.youtube.com/watch?v=Zyqpo8gxSO0&t=810s) retrieving an entity object from entityManager then modifying it, entityManager stays connected to that object and eventually flushes the changes to the db (at the end of the transaction) EVEN THOUGH WE DIDNT EXPLICITLY PERSIST THE RETRIEVED OBJECT BACK TO THE DB THROUGH entityManager
- [15:30](https://www.youtube.com/watch?v=Zyqpo8gxSO0&t=930s) lazy loading vs eager loading, if you try to iterate over an attribute that is lazily loaded, and you are outside a transaction, then you will get lazy loading exception
- [19:00](https://www.youtube.com/watch?v=Zyqpo8gxSO0&t=1140s) basics of JPA: you load entities through entityManager, which acts as a cache/collects db changes then flushes the changes to the db at the end of a transaction

————— spring data repositories —————
  -  [21:19](https://www.youtube.com/watch?v=Zyqpo8gxSO0&t=1279s) do I need a spring data repository for each entity?
  -  [23:42](https://www.youtube.com/watch?v=Zyqpo8gxSO0&t=1422s) complex derived query example