This is an application for creating a mortgage plan. Customers for
a bank want to borrow money, for a certain amount of years, and
pay off their debt every month with a certain interest rate. The application is calculating
their monthly payment according to this formula:
E = U[b(1 + b)^p]/[(1 + b)^p - 1],
where:

E = Fixed monthly payment,
b = Interest on a monthly basis, 
U = Total loan and
p = Number of payments.

The project written in Java, build, run and tested with Gradle.

In order to run the code application, You need a Java Virtual Machine
installed on Your computer. You also need Gradle installed. Once
You have forked the sourcecode, The application is started from the 
MainApp.class, which is found in the path MortgagePlan/main/java/application/
MainApp.

The folder test contains Unittest for all significant methods in the program
(with exception for example for getters and setters). This application can
be shared and distributed freely.

