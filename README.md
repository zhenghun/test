# test
1.完成了spring mvc、mybatis的集成
	需要注意的就是申明式事务管理方面，service不能使用try-catch捕获异常，一但捕获异常事务将不会回滚。