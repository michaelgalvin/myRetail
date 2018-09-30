# myRetail
This Service API retrieves product and price details by when a product id is passed in
### System requirements

This was written on OS X Sierra 10.12.6 with Cassandra as the datastore

### How to download and run on a Mac

`git clone https://github.com/michaelgalvin/myRetail.git`

`cd myRetail/`

`brew install cassandra`

`brew services start cassandra`

`cassandra`

Create a keyspace, a table and some data:

`cqlsh`

```
CREATE KEYSPACE targetdb WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3 };
use targetdb;
create table price (id INT PRIMARY KEY, value double, currency_code text);
insert into price (id, value, currency_code) values (13860428, 19.98, 'USD');
insert into price (id, value, currency_code) values (52696549, 39.99, 'USD')
insert into price (id, value, currency_code) values (75519802, 6.95, 'USD');
quit
```
Run the app:
```
./gradlew bootRun
```
### How to run tests
From the an IDE right click the src/test/groovy directory and choose "Run Tests"
