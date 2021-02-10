package com.jpmctechchallenge.finalsongtrack;
/*
 * @created 02/02/2021 - 17:32
 * @project jpmcTechChallenge
 * @author Rajender Singh
 * rajender created on 02/02/2021 inside the package - com.jpmctechchallenge.finalsongtrack
 */

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            List<Integer> listInInteger = getIntegerList(line);
            Integer M = Collections.max(listInInteger);
            List<Integer> finalIntegerList = applyWeightingFactorAndReturnFinalTrack(listInInteger, M);
            String finalTrack = finalIntegerList.stream()
                    .map(n -> String.valueOf(n))
                    .collect(Collectors.joining(","));
            System.out.println(finalTrack);
        }
    }

    public static List<Integer> getIntegerList(@NotNull String line) {
        List<String> listNum = new ArrayList<String>();
        listNum = Arrays.asList(line.split(","));
        List<Integer> listInInteger = new ArrayList<>();
        try {
            listInInteger = listNum.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return listInInteger;
    }

    public static List<Integer> applyWeightingFactorAndReturnFinalTrack(List<Integer> listInInteger, Integer M) {
        List<Integer> finalList = new ArrayList<>();
        finalList = listInInteger.stream().map(x -> ((x * 100) / M)).collect(Collectors.toList());
        return finalList;
    }
}
