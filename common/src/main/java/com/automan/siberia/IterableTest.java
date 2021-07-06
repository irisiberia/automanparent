package com.automan.siberia;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;
import com.google.common.io.LittleEndianDataInputStream;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @Author: he.zhou
 * @Date: 2019-04-07
 */
public class IterableTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        List<Integer> integerList = Lists.newArrayList();
        int offset = 0;
        while (true) {
            List<Integer> list1 = list.stream()
                    .skip(offset)
                    .limit(200).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(list1)) {
                break;
            }
            offset += 200;
            integerList.addAll(list1);
        }


        Iterable<List<Integer>> iterable = builIterable();

       List<Integer> integerList1= StreamSupport.stream(iterable.spliterator(), true)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

      integerList1.forEach(System.out::println);

    }

    private static Iterable<List<Integer>> builIterable() {

        Iterable<List<Integer>> iterable = () -> new AbstractIterator<List<Integer>>() {
            int offset = 0;
            boolean reachEnd = false;

            @Override
            protected List<Integer> computeNext() {
                if (reachEnd) {
                    return endOfData();
                }
                List<Integer> result = queryList(offset, 200);
                if (result.size() < 200) {
                    reachEnd = true;
                }
                if (result.isEmpty()) {
                    return endOfData();
                } else {
                    offset += 200;
                    return result;
                }
            }

            private List<Integer> queryList(int offset, int limit) {
                List<Integer> list = Lists.newArrayList();
                for (int i = 0; i < 1000; i++) {
                    list.add(i);
                }
                return list.stream()
                        .skip(offset)
                        .limit(200).collect(Collectors.toList());
            }
        };
        return iterable;
    }


}
