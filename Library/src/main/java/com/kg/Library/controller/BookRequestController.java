package com.kg.Library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kg.Library.Properties;
import com.kg.Library.model.Book;
import com.kg.Library.model.BookRequest;
import com.kg.Library.model.BookReview;
import com.kg.Library.model.LikeReview;
import com.kg.Library.repository.BookCategoryRepository;
import com.kg.Library.repository.BookRepository;
import com.kg.Library.repository.BookRequestRepository;
import com.kg.Library.repository.BookReviewRepository;
import com.kg.Library.repository.LikeReviewRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/bookRequest")
public class BookRequestController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookCategoryRepository bookCategoryRepository;
    @Autowired
    private BookRequestRepository bookRequestRepository;
    @Autowired
    private BookReviewRepository bookReviewRepository;
    @Autowired
    private LikeReviewRepository likeReviewRepository;
    @Autowired
    private Properties prop;

    @RequestMapping(value="/addrequest", method=RequestMethod.POST)
    public BookRequest savebookrLikereview(@RequestBody BookRequest bookrequest)
    {
        return bookRequestRepository.saveAndFlush(bookrequest);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<BookRequest> read() {
        System.out.println(bookRequestRepository.findAll());
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        List<BookRequest> br=bookRequestRepository.findAll().stream().filter(x->1 == (x.getUserid())).collect(Collectors.toList()); 
        Long likedbookstaken =bookRequestRepository.findAll().stream().filter(x->1 == (x.getUserid())).collect(Collectors.counting()); 
        System.out.println(likedbookstaken); 
        return bookRequestRepository.findAll();

    }
    @RequestMapping(value = "{requestid}", method = RequestMethod.PUT)
    public BookRequest update(@PathVariable Long requestid, @RequestBody BookRequest updatedRequest) {
        updatedRequest.setBookreqid(requestid);
        return bookRequestRepository.saveAndFlush(updatedRequest);
    }

    @RequestMapping(value = "{requestid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long requestid)
     {
        bookRequestRepository.deleteById(requestid);
    }
    @RequestMapping(value="{id}",method = RequestMethod.GET)
    public   HashMap<String, String> findone(@PathVariable Long id) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        List<BookRequest> br=bookRequestRepository.findAll().stream().filter(x->1 == (x.getUserid())).collect(Collectors.toList()); 
        Long bookstaken =bookRequestRepository.findAll().stream().filter(x->x.getUserid() == (id)).collect(Collectors.counting());
        String result1 = mapper.writeValueAsString(br);
        String result2 = mapper.writeValueAsString(bookstaken); 
        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap.put("BookRequestlist", result1);
        hmap.put("BooksTaken",result2);
        System.out.println(hmap); 
        System.out.println(bookstaken); 
        return hmap;
        // return bookRequestRepository.findById(id);
    }
    @RequestMapping(value="/multiple/{user_id}",method = RequestMethod.GET)
    public HashMap<String, String> findMultipleDetails(@PathVariable Long user_id) throws JsonProcessingException 
    {
        ObjectMapper mapper = new ObjectMapper();
        Long bookstaken =bookRequestRepository.findAll().stream().filter(x->x.getUserid() == (user_id)).collect(Collectors.counting());
        Long distinctBookCategory=bookRequestRepository.findbyuserid(user_id);
        Long reviewPoints=bookReviewRepository.findbyreviewId(user_id);
        String result1 = mapper.writeValueAsString(bookstaken);
        String result2 = mapper.writeValueAsString(distinctBookCategory); 
        String result3 = mapper.writeValueAsString(reviewPoints);
        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap.put("BooksTakenbyUser", result1);
        hmap.put("DistinctBookCategory",result2);
        hmap.put("UserReviewPoints",result3);
        System.out.println(hmap); 
        System.out.println(bookstaken);
        return hmap;
    }
    @RequestMapping(value="/multipleModel/{userId}",method = RequestMethod.GET)
    public HashMap<String, String> sendMultipleDetails(@PathVariable Long userId) throws JsonProcessingException 
    {
        ObjectMapper mapper = new ObjectMapper();
        List<Book> booklist=bookRepository.findAll();
        List<BookRequest> bookrequest =bookRequestRepository.findAll();
        List<BookRequest> lstBookRequest = bookRequestRepository.findByUserid(userId);
        List<BookReview> lstBookReview = bookReviewRepository.findByUserid(userId);
        List<LikeReview> lstlikeReview = likeReviewRepository.findByUserid(userId);
        String res=mapper.writeValueAsString(booklist);
        String result = mapper.writeValueAsString(bookrequest);
        String result1 = mapper.writeValueAsString(lstBookRequest);
        String result2 = mapper.writeValueAsString(lstBookReview);
        String result3 = mapper.writeValueAsString(lstlikeReview);
        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap.put("BooksList",res);
        hmap.put("BookRequest", result);
        hmap.put("BookRequestByUser", result1);
        hmap.put("BooksReviewByUser", result2);
        hmap.put("LikeReviewByUser", result3);
        return hmap;
    }
    @RequestMapping(value="/streamResult/{userId}",method = RequestMethod.GET)
    public void StreamManipulation(@PathVariable Long userId) 
    {
        List<Book> booklist=bookRepository.findAll();
        List<BookRequest> bookrequest =bookRequestRepository.findAll();
        List<BookRequest> lstBookRequest = bookRequestRepository.findByUserid(userId);
        List<BookReview> bookReview = bookReviewRepository.findAll();
        List<LikeReview> likeReview = likeReviewRepository.findAll();
        //Book Count in Book table
        long booksCount=booklist.stream().count();
        System.out.println("@@ Books Count in List @@  "+booksCount);
        //BOOKS name in Book Table
        List<String> booksName=booklist.stream().map(x->x.getBookname()).collect(Collectors.toList());
        System.out.println("@@ Books Name in List @@  "+booksName);
        //Books Taken by user in Book Request  Table,not distinct books list
        Long bookstaken =bookrequest.stream().filter(x->x.getUserid() == (userId)).map(x->x.getBookid()).distinct().collect(Collectors.counting());
        System.out.println("** Books Taken By User,not distinct **  "+bookstaken);
        //Books Category Wise Count,not distinct book category
        Map<Long, Long> strmap = lstBookRequest.stream().collect(Collectors.groupingBy(BookRequest::getBookid, Collectors.counting()));
        System.out.println("** Book Category wise count:not distinct **  " + strmap);
        //Books Taken by User in Book Request Table,Distinct Book list
        Long bookstakenDistinct =bookrequest.stream().filter(x->x.getUserid() == (userId)).map(x->x.getBookid()).distinct().collect(Collectors.counting());
        System.out.println("++ Books Taken By User,not distinct ++  "+bookstakenDistinct);
        //Books Category Wise Count, distinct category
        List<Long> strmapDistinct = lstBookRequest.stream().map(BookRequest::getBookid).distinct().collect(Collectors.toList());
        System.out.println("++ Book Category wise count:distinct ++  " + strmapDistinct);
        //Review Done by User For Books
        List<Long> reviewForBooksByUser=bookReview.stream().filter(x->x.getUserid()==userId).map(x->x.getBookrevid()).distinct().collect(Collectors.toList());
        System.out.println("%% Review For Books %%   "+reviewForBooksByUser);
        Long reviewpoint = reviewForBooksByUser.stream().collect(Collectors.counting());
        System.out.println("** the reviewpoint: **" + reviewpoint * prop.getPointsforreview());
        //More than one book take from same category
        Map<Object,Object> morethan1=strmap.entrySet().stream().filter(x -> x.getValue() >= 5).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        System.out.println("** More Than Five ** "+morethan1);
        Long morethan1Book=strmap.entrySet().stream().filter(x -> x.getValue() >= 5).collect(Collectors.counting());
        System.out.println("More Than Five Book from Same Category"+morethan1Book);
        //Review for Books Liked by User
        Map<Long, Long> strmap1 = likeReview.stream().collect(Collectors.groupingBy(LikeReview::getRevid, Collectors.counting()));
        System.out.println("More than 5 likes for same Review"+strmap1);
        Long morethan5Like=strmap1.entrySet().stream().filter(x -> x.getValue() >= 5).collect(Collectors.counting());
        System.out.println("More Than Five Like for Reviews"+morethan5Like);
        //Popular reader
        Map<Long, Long> PopularReader=bookrequest.stream().collect(Collectors.groupingBy(BookRequest::getUserid,Collectors.counting()));
        System.out.println("Popular Reader List"+PopularReader);
        Map<Long, Long> PopularBook=bookrequest.stream().collect(Collectors.groupingBy(BookRequest::getBookid,Collectors.counting()));
        System.out.println("Popular Book List"+PopularBook);
        //Liked Books Taken By User
        List<Long> reviewbook1 = likeReview.stream().filter(x -> x.getUserid() == userId).map(x -> x.getRevid()).collect(Collectors.toList());
        System.out.println("ffffdf"+reviewbook1);
        Long likedbookstaken1 = bookrequest.stream().map(x -> x.getBookreqid()).filter(reviewbook1::contains).collect(Collectors.counting());
        System.out.println("Liked Books Taken"+likedbookstaken1);
    }
}