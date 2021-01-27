package com.example.simplerestapis.models;

import java.util.List;
import lombok.Data;

/**
 *
 * @author mafuj.jia
 */
@Data
public class PostResponse {

    List<Long> result;

    String message;

    String id;
}
