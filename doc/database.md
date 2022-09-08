### Database

The database is a local in-memory H2 database that is automatically connected to by the Spring framework based on values in the `application.properties` file. It utilizes JPA for executing generated queries which provides protection against SQL injection attacks and relieves the developer from having to write queries or stored procedures. These JPA methods are either built-in functions (like `save()`) or are located in the appropriate Repository file.

Migration scripts located in `/resources/db/migration` are run in order of version number (dictated by the filename where Vx_y__name is version x.y) when the application starts.  The app is set to run them fresh every time (or baseline-on-migrate) due to the early stages of development.  A production app would maintain a set of scripts in a similar structure that would only run if their checksum is changed and likely more scripts just like these that are configured to only run in development environments.

Some basic values have been populated into the tables via these migration scripts.