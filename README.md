# design-pattern

旨在学习设计模式，写些学习代码，以作分享

开发工具及环境：idea、jdk8、maven

适配器模式(Adapt)：将一个类的接口转换为客户端希望的另一种接口
	类适配器：通过继承创建的适配器
	对象适配器：通过组合创建的适配器
外观模式（Facade）：把一些复杂的流程封装成一个接口供外部用户更简单的使用，使得客户端和子系统之间解耦，让子系统内部的模块功能更容易扩展和维护

合成模式(Composite): 允许你将对象组合成树形结构来表现“整体/部分”层次结构，合成模式能让客户以一致的方式处理个别对象以及对象的组合

桥接模式（Bridge）: 可以取代多层继承的方案。多层继承违背了单一职责原则，复用性较差，类的种类也非常多。桥接模式可以极大的减少子类的个数，从而降低管理和维护的成本。

单例模式（Singleton）:只创建出一个对象
			恶汉：立即加载。类加载进内存就创建了对象
			懒汉：延迟加载。需要使用的时候才会创建

观察者模式（Observer）: 在被观察者更新了信息后，观察者会立即更新信息。

调停者模式（Mediator）: 使用调停者模式将需求的发起者和执行者之间的强耦合进行了降低，极大的优化了系统内部的维护工作
			调停者模式降低的是系统内部的耦合性，而外观模式是降低系统之间的耦合性

享元模式（Flyweight）:  运用共享技术有效地支持大量细粒度对象的复用。
			享元模式会创建一个享元池将这些公共的实例保存在享元池中。可以针对的创建不同的对象，然后通过复用的方式进行分配，需要的时候就将对应的对象取出，不需要就放回

构造者模式（Build）:    在创建对象的时候，可以随意组合输入的参数，不仅避免了重载出错的问题，还不需要写过多的构造器
			就是在类中内部创建一个内部类，并且拥有和创建类一样的字段（属性），并且提供set方法，并且提供一个返回对象的方法（build）,这样就可以通过Builder来创建User对象
			
工厂模式（Factory Method）: 凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法创建
			    分为：普通工厂、多个工厂、静态工厂

抽象工厂模式（Abstract Factory）: 创建多个工厂类，一旦需要新增功能，直接新增新的工厂类就可以了，不用修改原来的代码，这样就符合了闭包原则

原型模式（Prototype）:  可以通过原型对象克隆出多个一模一样的对象。也就是所谓的克隆
			主要分为浅克隆和深克隆：浅克隆是将对象进行复制，引用对象指向同一地址（实现cloneable接口），深克隆是将对象进行复制，并再将引用对象进行复制，使得引用的成员变量指向不同的地址（一般使用序列号和反序列化 ）
			浅克隆和深克隆的主要区别在于是否支持引用类型的成员变量的复制

备忘录模式（Memento）:	又称为（Token）标记模式，在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态

策略模式（Strategy）:  策略模式通过接口或抽象类封装算法的标识，即在接口中定义一个抽象方法，实现该接口的类将实现接口中的抽象方法。策略模式把针对一个算法标识的一系列具体算法
		       分别封装在不同的类中，使得各个类给出的具体算法可以相互替换。

命令模式（Command）:   将一个请求封装为一个对象，从而让我们可用不同的请求对客户进行参数化；对请求排队或者记录请求日志，以及支持可撤销操作
			命令模式是一种对象行为型模式，别名为动作模式或事务模式

解释器模式（Interpreter）: 给分析对象定义一个语言，并定义该语言的文法表示，再设计一个解析器来解释语言中的句子。也就是说，用编译语言的方式来分析应用中的实例。这种模式实现了文法表达式处理的接口，该接口解释一个特定的上下文。
			   抽象解释器：具体的解释任务由各个实现类完成
			   终结符表达式：实现与文法中的元素相关联的解释操作，通常一个解释器模式中只有一个终结表达式，但有多个实例对应不同的终结符
			   非终结符表达式（NonterminalExpression）：文法中的每条规则对应于一个非终结表达式，非终结符表达式根据逻辑的复杂程度而增加，原则上每个文法规则都对应一个非终结符表达式
			   上下文（Context）: 上下文环境类,包含解释器之外的全局信息 
			   客户类（Test）: 客户端,解析表达式,构建抽象语法树,执行具体的解释操作等. 

装饰者模式（Decorator）:  诠释了对扩展开发，对修改关闭原则的设计模式，一个类需要新增行为时，使用装饰器模式，可以在不修改原类的基础上，完成行为的增加。
		          装饰着模式是为了解决，当现有接口无法满足业务需求的一种补救方式，他可以在方法的前后进行包装，不仅如此，它能无限包装，当业务再次发生改变时，能很快的进行调整

迭代器模式（Iterator）:  提供一种方法顺序的访问一个聚合对象中的各个元素，而又不暴露该对象的内部表示
		     一般用来遍历容器用的，大部分情况不需要我们实现，直接使用像ArrayList,HashMap中的Iterator就行了

访问者模式（Visitor）:  将访问数据的过程分为访问者、被访问者、结构整合类、3个对象，解耦了访问过程，当被访问物是恒定的，不需要修改时，可以使用这种模式，如果访问物要修改时，不能使用这个模式