package com.space.space;

import org.springframework.stereotype.Service;

@Service
public class SampleJobService {

    public void executeSampleJob() {
        System.err.println("Job executed");
    }
}
