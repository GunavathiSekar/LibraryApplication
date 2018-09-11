package com.kg.Library.controller;

import java.util.stream.*;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kg.Library.model.Employee;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/employeeStream")
public class EmployeeStream
 {
    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> findone() 
    {
        String[] name={"guna","va","thi"};
        List<Employee> employees=Arrays.asList(new Employee("Dhamodharan",32),new Employee("Gunavathi",27),new Employee("Manikandan",26),new Employee("Sekar",59));
        System.out.println(employees);
        employees.stream().max(Comparator.comparing(Employee::getName)).ifPresent(x->System.out.println("sort max"+x));
        employees.stream().min(Comparator.comparing(Employee::getName)).ifPresent(x->System.out.println("sort min"+x));
        System.out.println("Sorted");
        List<Employee> sortedlist = employees.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
		sortedlist.forEach(System.out::println);
        //count
        long EmpCount=employees.stream().filter(e->e.getName().endsWith("n")).count();
        System.out.println("++Ends With N++"+EmpCount);
        //foreach and distinct
        List<String> distinctList=employees.stream().map(Employee::getName).distinct().collect(Collectors.toList());
        System.out.println("__Distinct List__");
        distinctList.forEach(System.out::println);
        //skip
        System.out.println("%% Skip %%");
        employees.stream().skip(2).forEach(System.out::println);
        //limit
        System.out.println("$$ Limit $$");
        employees.stream().limit(1).forEach(System.out::println);
        //allmatch
        boolean allmatch = employees.stream().allMatch(p->p.getAge()>26 && p.getName().startsWith("G"));
        System.out.println("## All Match ##"+allmatch);
        //nonematch
        boolean nonematch = employees.stream().noneMatch(p->p.getAge()>26 && p.getName().startsWith("m"));
        System.out.println("@@ No Match @@"+nonematch);
        //anymatch
        boolean anymatch = employees.stream().anyMatch(p->p.getAge()>28 && p.getName().startsWith("s"));
        System.out.println("## Any Match ##"+anymatch);
        //Find Minimum value
        employees.stream().min(Comparator.comparing(Employee::getName)).ifPresent(s->System.out.println("sort by alphabet order person min "+s));
        //using filter
        List<Employee> empList=employees.stream().filter(s->s.getName().endsWith("n")).collect(Collectors.toList());
        System.out.println("** Filtered Employee List **"+empList);
        empList.stream().forEach(System.out::println);
        //reduce
        String fullname=Arrays.stream(name).reduce("",(a,b)->a+b);
        System.out.println("Reduce: Full Name"+  fullname);
        int[] numarr={1,2,3,4,5};
        int noRes=Arrays.stream(numarr).reduce(1,(a,b)->a+b); // 1 is the initial value 1+2+3+4+5=15
        System.out.println("Reduce: result"+noRes);
        //Peek
        List<Integer> numArray=Arrays.asList(1,2,3,4,5);
        numArray.stream().peek(i->System.out.println("++ Peek ++"+i*i)).collect(Collectors.toList());
        //find Any
        Optional<Employee> emplist1=employees.stream().filter(emp->emp.getAge()>35).findAny();
        if(emplist1.isPresent())
        {
            System.out.println("** Find Any **"+emplist1.get());
        }
        //Find First
        Optional<Employee> emplist2=employees.stream().filter(emp->emp.getAge()>20).findFirst();
        if(emplist1.isPresent())
        {
            System.out.println("++ Find First  ++"+emplist2.get());
        }
        //mapToInt MapToLong mapToDouble
        int intSum = employees.stream().mapToInt(Employee::getAge).sum();
        System.out.println("Map To Int"+intSum);
        long longSum = employees.stream().mapToLong(Employee::getAge).sum();
        System.out.println("Map To Long"+longSum);
        double doubleSum = employees.stream().mapToDouble(Employee::getAge).sum();
        System.out.println("Map To Double"+doubleSum);
        double doubleAvg = employees.stream().mapToDouble(Employee::getAge).average().getAsDouble();
        System.out.println("Map To Double"+doubleAvg);
        //stream builder
        Stream.Builder<Integer> builder = Stream.builder();
        builder.accept(1);
        builder.accept(2);
        builder.accept(3);
        builder.accept(4);
        Stream<Integer> res = builder.build();
        System.out.println("stream builder");
        res.forEach(System.out::println); 
         //flat map
       String[][] data = new String[][]{{"A", "B"}, {"C", "D"}, {"E", "G"}};
       Stream<String> dataRes=Arrays.stream(data).flatMap(x -> Arrays.stream(x)).filter(x -> "C".equals(x.toString()));
       dataRes.forEach(System.out::println);
        return employees;
      }
    }
       
