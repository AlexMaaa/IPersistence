### 1、Mybatis动态sql是做什么的？都有哪些动态sql？简述一下动态sql的执行原理？
动态sql可以方便我们针对不同的条件使用不通的sql，可以减少代码量，避免sql拼接
动态sql标签有：choose，when,otherwise,if,set(update时候用)，trim，where ，foreach
### 2、Mybatis是否支持延迟加载？如果支持，它的实现原理是什么？
支持延迟加载。进行关联查询时，按照设置延迟规则推迟对关联对象的select查询。延迟加载可以有效的减少数据库压力。
实现原理：查询封装结果集时判断是否有嵌套查询，如果有则创建代理对象，根据aggressive属性，判断是否一次性加载所有属性，或者触发延迟加载
### Mybatis都有哪些Executor执行器？它们之间的区别是什么？
SimpleExecutor：每执行一次update或select，就开启一个Statement对象，用完立刻关闭Statement对象。
ReuseExecutor：执行update或select，以sql作为key查找Statement对象，存在就使用，不存在就创建，用完后，不关闭Statement对象，而是放置于Map内，供下一次使用。简言之，就是重复使用Statement对象。
BatchExecutor：执行update（没有select，JDBC批处理不支持select），将所有sql都添加到批处理中（addBatch()），等待统一执行（executeBatch()），它缓存了多个Statement对象，每个Statement对象都是addBatch()完毕后，等待逐一执行executeBatch()批处理。与JDBC批处理相同。
在Mybatis配置文件中，可以指定默认的ExecutorType执行器类型，也可以手动给DefaultSqlSessionFactory的创建SqlSession的方法传递ExecutorType类型参数。
### 简述下Mybatis的一级、二级缓存（分别从存储结构、范围、失效场景。三个方面来作答）？
一级缓存：
    存储结构：hashMap
    范围：sqlSession key为hashcode+statementId+sql
    失效场景：sqlSession.close,或者有CUD操作
二级缓存：
    存储结构：hashMap
    范围：namespace
    失效场景：连表查询，更改附表数据，不在同一个namespace下的化缓存会出现脏数据的情况，分布式系统也会出现同样问题不推荐使用
### 简述Mybatis的插件运行原理，以及如何编写一个插件？
mybatis提供利用插件拦截四大组件，基于动态代理对其进行增强的功能
四大组件为：执行器Excutor（update，query，commit，rollback等功能）
          sql语法构建器StatementHandler
          参数处理器parameterHandler
          结果处理器resultSetHandler
具体实现：插件配置标签@Intercepts里面@Signature，配置拦截的组件类型，方法，参数类型
        插件实现Interceptor接口
        配置到sqlMapConfig中的Plugins标签中
            

    