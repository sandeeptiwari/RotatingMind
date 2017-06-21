I am reading the spring site to understand Spring Autowired annotation:

http://docs.spring.io/spring/docs/3.0.x/reference/beans.html#beans-autowired-annotation

3.9.2 @Autowired and @Inject

I am not able to understand the below examples. Do we need to do something in the XML for it to work?

EXAMPLE 1

public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Autowired
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // ...
}
EXAMPLE 2

public class MovieRecommender {

    private MovieCatalog movieCatalog;

    private CustomerPreferenceDao customerPreferenceDao;

    @Autowired
    public void prepare(MovieCatalog movieCatalog,
                    CustomerPreferenceDao customerPreferenceDao) {
        this.movieCatalog = movieCatalog;
        this.customerPreferenceDao = customerPreferenceDao;
    }

    // ...
}
How can the two classes be autowired implementing the same interface and using the same class?

Example:

class Red implements Color
class Blue implements Color

class myMainClass{
    @Autowired 
    private Color color;

    draw(){
        color.design(); 
    } 
}
Which design method will be called? How do I make sure the design method of Red class will be called and not Blue?

The @Autowired annotation allows you to skip configurations elsewhere of what to inject and just does it for you. Assuming your package is com.mycompany.movies 
you have to put this tag in your XML (application context file):

<context:component-scan base-package="com.mycompany.movies" />

This tag will do an auto-scanning. Assuming each class that has to become a bean is annotated with a correct annotation like @Component 
(for simple bean) or @Controller (for a servlet control) or @Repository (for DAO classes) and these classes are somewhere under the 
package com.mycompany.movies, Spring will find all of these and create a bean for each one. This is done in 2 scans of the classes - 
the first time it just searches for classes that need to become a bean and maps the injections it needs to be doing, and on the second 
scan it injects the beans. Of course, you can define your beans in the more traditional XML file or with a @Configuration class (or any combination of the three).

The @Autowired annotation tells Spring where an injection needs to occur. If you put it on a method setMovieFinder it understands 
(by the prefix set + the @Autowired annotation) that a bean needs to be injected. In the second scan, Spring searches for a bean of type MovieFinder, and if 
it finds such bean, it injects it to this method. If it finds two such beans you will get an Exception. To avoid the Exception, you can use the @Qualifier 
annotation and tell it which of the two beans to inject in the following manner:

@Qualifier("redBean")
class Red implements Color {
   // Class code here
}

@Qualifier("blueBean")
class Blue implements Color {
   // Class code here
}
Or if you prefer to declare the beans in your XML, it would look something like this:

<bean id="redBean" class="com.mycompany.movies.Red"/>

<bean id="blueBean" class="com.mycompany.movies.Blue"/>
In the @Autowired declaration, you need to also add the @Qualifier to tell which of the two color beans to inject:

@Autowired
@Qualifier("redBean")
public void setColor(Color color) {
  this.color = color;
}
If you don't want to use two annotations (the @Autowired and @Qualifier) you can use @Resource to combine these two:

@Resource(name="redBean")
public void setColor(Color color) {
  this.color = color;
}
The @Resource (you can read some extra data about it in the first comment on this answer) spares you the use of two annotations and instead you only use one.

I'll just add two more comments:

Good practice would be to use @Inject instead of @Autowired because it is not Spring-specific and is part of the JSR-330 standard.
Another good practice would be to put the @Inject / @Autowired on a constructor instead of a method. If you put it on a constructor, you can validate 
that the injected beans are not null and fail fast when you try to start the application and avoid a NullPointerException when you need to actually use the bean.
So, to sum it up: The @Autowired annotation spares you the need to do the wiring by yourself in the XML file (or any other way) and just finds for you 
what needs to be injected where, and does that for you.

Update: To complete the picture, I created a new question about the @Configuration class.
 	
Just for complete your awesome answer: '@Resource' is part of the JSR-250 standard and has extra semantics over and above simple injection 
(As you have said '@Autowired' is from Spring; and '@Inject' is part of the JSR-330) :) – Ignacio Rubio Sep 1 '14 at 15:12
  	 	
If MovieFinder is a Interface, and we have a bean for MovieFinderImpl(bean id = movieFinder), Spring will auto inject it by type or by name? – 
Jaskey Aug 8 '15 at 12:37
  	 	
@jaskey - it depends on whether you use @Qualifier. If you do - by name, if not - by type. By-type would work only if you have only one bean of type 
MovieFinder in your context. More than 1 would lead to an exception. – Avi Aug 8 '15 at 17:07
  	 	
@Avi, Awesome answer. But I do not understand how the @Autowired annotation works on the prepare method in Example 2. It is initializing the MovieRecommender
 but, technically, it is NOT a setter. – Karan Chadha Feb 28 at 9:26 
  	 	
@KaranChadha - The @Autowired also works for constructors. It finds the required dependencies and injects them to the constructor. – Avi Feb 28 at 9:59
add a comment

up vote
15
down vote
Nothing in the example says that the "classes implementing the same interface". MovieCatalog is a type and CustomerPreferenceDao is another type. 
Spring can easily tell them apart.

In Spring 2.x, wiring of beans mostly happened via bean IDs or names. This is still supported by Spring 3.x but often, you will have one instance of a 
bean with a certain type - most services are singletons. Creating names for those is tedious. So Spring started to support "autowire by type".

What the examples show is various ways that you can use to inject beans into fields, methods and constructors.

The XML already contains all the information that Spring needs since you have to specify the fully qualified class name in each bean. You need to be a
 bit careful with interfaces, though:

This autowiring will fail:

 @Autowired
 public void prepare( Interface1 bean1, Interface1 bean2 ) { ... }
Since Java doesn't keep the parameter names in the byte code, Spring can't distinguish between the two beans anymore. The fix is to use @Qualifier:

 @Autowired
 public void prepare( @Qualifier("bean1") Interface1 bean1,
     @Qualifier("bean2")  Interface1 bean2 ) { ... }
shareimprove this answer
edited Jan 28 '16 at 10:52
answered Oct 17 '13 at 8:49

Aaron Digulla
214k65386601
  	 	
typo in the annotation: @Autowired – Bajal Jan 28 '16 at 1:43
  	 	
@Bajal Thanks, fixed. – Aaron Digulla Jan 28 '16 at 10:53
add a comment
up vote
4
down vote
Yes, you can configure the Spring servlet context xml file to define your beans (i.e., classes), so that it can do the automatic injection for you. 
However, do note, that you have to do other configurations to have Spring up and running and the best way to do that, is to follow a tutorial ground up.

Once you have your Spring configured probably, you can do the following in your Spring servlet context xml file for Example 1 above to work 
(please replace the package name of com.movies to what the true package name is and if this is a 3rd party class, then be sure that the appropriate 
jar file is on the classpath) :

<beans:bean id="movieFinder" class="com.movies.MovieFinder" />
or if the MovieFinder class has a constructor with a primitive value, then you could something like this,

<beans:bean id="movieFinder" class="com.movies.MovieFinder" >
    <beans:constructor-arg value="100" />
</beans:bean>
or if the MovieFinder class has a constructor expecting another class, then you could do something like this,

<beans:bean id="movieFinder" class="com.movies.MovieFinder" >
    <beans:constructor-arg ref="otherBeanRef" />
</beans:bean>
where 'otherBeanRef' is another bean that has a reference to the expected class.
 	
Defining all the wiring in the XML just misses the whole idea of @Autowired – Avi Oct 17 '13 at 6:51


@Autowired

Let Spring auto-wire other beans into your classes using @Autowired annotation.

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    ...
}
Spring Annotation Tip Spring beans can be wired by name or by type. @Autowire by default is a type driven injection. @Qualifier spring annotation can be used 
to further fine-tune autowiring. @Resource (javax.annotation.Resource) annotation can be used for wiring by name. Beans that are themselves defined as a 
collection or map type cannot be injected through @Autowired, because type matching is not properly applicable to them. Use @Resource for such beans, referring 
to the specific collection or map bean by unique name