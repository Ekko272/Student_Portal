```java
@RequestMapping(value={"/addClassPage", "/addmoreClassPage"})
//handle multiple address. handle any type of request if "method" is not declared
```

RESTful style path:
```java
<a th:href="@{/testRest/1/admin}">测试路径中的占位符-->/testRest</a><br>
@RequestMapping("/testRest/{id}/{username}")
public String testRest(@PathVariable("id") String id, @PathVariable("username") String username){
    return new String();
}
```

**testing git**