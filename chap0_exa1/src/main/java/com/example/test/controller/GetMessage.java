package com.example.test.controller;

import com.example.test.dao.BookMapper;
import com.example.test.dao.UserMapper;
import com.example.test.pojo.Book;
import com.example.test.pojo.User;
import com.example.test.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class GetMessage
{
    @Autowired
    UserMapper userMapper;
    @Autowired
    BookMapper bookMapper;
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public User f1(@RequestBody User user)
    {
        System.out.println(user);
        return user;
    }
    @RequestMapping(value = "/user/{id}")
    @ResponseBody
    public User f2(@PathVariable(value = "id") int id)
    {
        User user = userMapper.getById(id);
        if (user == null) {
            return new User(9999, "NA", "NA");
        }
        else {
            return user;
        }
    }
    @RequestMapping(value = "/book/{name}")
    @ResponseBody
    public Result<?> f3(@PathVariable(value = "name") String name)
    {
        List<Book> list = bookMapper.getListByName(name);
        return new Result<>(list);
    }
    @RequestMapping(value = "/book/insert")
    @ResponseBody
    public Result<?> f4(Book book)
    {
        bookMapper.insertByBook(book);
        return new Result<>(book.getId());
    }
}
