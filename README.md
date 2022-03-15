# WebPOS

The demo shows a simple POS system in MVC architecture, which replaces the shell interface in aw02 with a pos web
ui (https://github.com/bshbsh404/simple-pos-ui
).

![](screenshot.png)

To run

```shell
mvn clean spring-boot:run
```

Currently, it just lists the products for sale with a cart with one item (just for demonstration).

Please read the tutorial at  https://www.baeldung.com/spring-boot-crud-thymeleaf and make the POS system robust and
fully functional. You can also refer to other articles, for instance https://www.baeldung.com/tag/thymeleaf/ .

And please elaborate your understanding in MVC architecture via this homework in your README.md.

# My Understanding of MVC Architecture

1. MVC is a software architecture that separates the application to different layers, namely Model, View, Controller.
2. Model layer contains data layout and how to arrange the data. It's the basis of the application view.
3. View layer is the interface between user and data. It generates from data from model layer and render the view for
   the user.
4. Controller layer is the interface between user and model layer. It handles the user request and pass the request to
   model layer.
