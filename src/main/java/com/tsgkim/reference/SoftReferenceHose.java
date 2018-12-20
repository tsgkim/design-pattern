package com.tsgkim.reference;

import com.google.common.collect.Lists;

import java.lang.ref.SoftReference;
import java.util.List;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/12/3 11:15 AM
 */
public class SoftReferenceHose {

    List<SoftReference> houses = Lists.newArrayList();




}

class House {

    public Door[] doors = new Door[2000];

    class Door {}
}
