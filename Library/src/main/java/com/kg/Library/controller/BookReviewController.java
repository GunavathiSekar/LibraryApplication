package com.kg.Library.controller;


import com.kg.Library.model.BookReview;
import com.kg.Library.repository.BookReviewRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/bookReview")
public class BookReviewController {
    @Autowired
    BookReviewRepository bookreviewRepository;

    @Autowired
    BookReviewRepository booklikeRepository;

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public BookReview savebook(@RequestBody BookReview bookreview)
    {
        return bookreviewRepository.saveAndFlush(bookreview);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<BookReview> read() {
        return bookreviewRepository.findAll();
    }
    @RequestMapping(value = "{bookreviewid}", method = RequestMethod.PUT)
    public BookReview update(@PathVariable Long bookreviewid, @RequestBody BookReview updatedBookreview) {
        updatedBookreview.setBookrevid(bookreviewid);
        return bookreviewRepository.saveAndFlush(updatedBookreview);
    }

    @RequestMapping(value = "{bookreviewid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long bookreviewid) {
        bookreviewRepository.deleteById(bookreviewid);
    }
}