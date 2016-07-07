package com.generic.webproject.controller;

import com.generic.webproject.data.ChordDTO;
import com.generic.webproject.entity.Chord;
import com.generic.webproject.service.ChordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/chord", headers = {"Accept=application/json"})
public class ChordController extends GenericCrudController<Chord, ChordDTO, ChordService>{

    @Inject
    private ChordService chordService;

    @Override
    public ChordService getService() {
        return chordService;
    }

//    @RequestMapping(value = "/repeat", method = POST)
//    public ChordDTO repeat(){
//        return chordService.repeat();
//    }

}
