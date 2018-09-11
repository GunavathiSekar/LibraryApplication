package com.kg.Library.controller;

import org.springframework.web.bind.annotation.RequestBody;
import com.kg.Library.model.LikeReview;
import com.kg.Library.repository.LikeReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/bookLike")
public class LikeReviewController {
    @Autowired
    LikeReviewRepository bookLikeRepository;

    @RequestMapping(value="/addbooklike", method=RequestMethod.POST)
    public LikeReview savebookrLikereview(@RequestBody LikeReview booklike)
    {
        return bookLikeRepository.saveAndFlush(booklike);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<LikeReview> read() {
        return bookLikeRepository.findAll();
    }
    @RequestMapping(value = "{likeid}", method = RequestMethod.PUT)
    public LikeReview update(@PathVariable Long likeid, @RequestBody LikeReview updatedBooklike) {
        updatedBooklike.setLikeid(likeid);
        return bookLikeRepository.saveAndFlush(updatedBooklike);
    }

    @RequestMapping(value = "{likeid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long likeid)
     {
        bookLikeRepository.deleteById(likeid);
    }
    // @RequestMapping(value = "/getUserLikes/{userid}",method = RequestMethod.GET)
    // public Iterable<LikeReview> listuserReview(@PathVariable Long userid) {
    //     return bookLikeRepository.findbyreviewId(userid);
    // }
}