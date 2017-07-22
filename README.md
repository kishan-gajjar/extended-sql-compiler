# extended-sql-compiler
This is limited functionality SQL compiler to remove tight coupling between aggregates functions and group by clause, resulting in faster execution of data mining queries

The software generates Java files based on the input file which runs as separate project. This generated Java files when runned produces the desired sql output table. The preferred input to software is .txt file with specific format as discussed in section # Input file explained

# Software versions
- JavaSE 1.8
- Eclipse Neon.3 Release (4.6.3) 
- PostgreSQL v. 9.6.3

# Getting Started
Checkout this repository:
```
> git clone https://github.com/kishan-gajjar/extended-sql-compiler.git
> cd extended-sql-compiler
```

Import project in eclipse
```
> go to File -> Import -> General -> Existing Projects into Workspace
> select extended-sql-compiler folder
> open Java Build Path for project -> Add external Jar and select -> extended-sql-compiler\jarfiles\postgresql-8.3-604.jdbc4

```

This file is not yet complete.
