package com.appapplication.com.Type;

import java.util.List;

public interface TypeService {


    boolean addType(Long applicationId,Long userApplicationId,Type type);

    List<Type> getAllType();

    List<Type> getType(Long applicationId, Long userApplicationId, Long usertypeId);
}
