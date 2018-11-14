evshang是一个spring cloud + vue的项目
# 使用的技术

> 主要使用技术spring cloud组件,spring security做安全框架集成在网关模块(此处参考网上的安全代码),redis缓存,mysql,vue做数据展示,持久层框架暂时用jpa,zipkin做服务链路监控


> 微服务总是会和maven多模块混在一起理解，这是错误的概念，maven多模块适合项目代码的组装，如果是独自维护自己的服务是可以使用的。微服务则是远程调用的概念。
因为这个代码都是放在一起的，所以使用Maven多模块
可能会很容易理解，但是如果放在一个大公司里，有很多部门，部门有自己的服务器，各个服务有自己的docker搭建的nexus服务器。

> 项目开发构建中最常用的方式就是我搭建一个父模块的pom，然后子模块继承这个父模块，使用公共的配置，公共的组件等，但是在微服务中不推荐这样。

> 如果你是一两个人在开发spring cloud的微服务项目，那么可以使用父模块的方式，但是会给你后期重构增加压力.

> 因为spring cloud里面一个概念是服务独立部署，彼此通过服务调用访问，所以就不使用父模块的pom提供公共配置，组件的方式了（当然你也可以配置这个，仅仅为了打包方便，
当然你可以在自己的服务里使用这样的方式），所有的服务都是自己管理.如果是自己一人开发会有很多重复代码，但那是在公司实际开发的时候彼此部门的服务是独立维护的，也不抽象独立组件。

> 开始的时候我使用了父模块pom.xml这样的方式构建项目，控制版本，打包等操作，但是存在问题，我a服务可能使用boot1.5，结合hibernate做持久层，b服务使用boot2.0使用mybatis plus,
这都是可以的（不要站在传统的角度看待这个：就是我这个公司必须要用这个版本必须要用这个框架）

> 随着公司发展规模变大，开发人员逐渐增多，业务扩大，公司的开发语言也变多了，会有很多部门去维护很多服务，如果是把实体类抽象成一个公共组件，对于java来说肯定是最好的，但是对于python,go等语言来说没办法使用，所以推荐是各个服务之间维护自己的实体类，服务调用者根据返回的json数据取里面有价值的
字段，重新封装成一个对象进行自己服务的业务处理。虽然会增加实体类的重复代码，所以此处我推荐使用lombok组件，封装对象。

