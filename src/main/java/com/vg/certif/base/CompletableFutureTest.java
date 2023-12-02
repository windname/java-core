package com.vg.certif.base;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class CompletableFutureTest {
    public static void main(String[] args) {
        new CompletableFutureTest();
    }

    public CompletableFutureTest() {
        computation();
        processResult();
        combine();
        java9();
    }

    public void computation() {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> "Hello supply async");
        System.out.println(completableFuture.join());

        CompletableFuture completableFuture1 = CompletableFuture.runAsync(() -> System.out.println("Hello runSync"));
    }

    public void processResult() {
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Final result");

        // return the same type
        CompletableFuture<String> result = completableFuture.thenApply(s -> "Apply to " + s);
        System.out.println(result.join());

        CompletableFuture result2 = completableFuture.thenAccept(s -> System.out.println("Accept" + s));
        result2.join();

        completableFuture.thenRun(() -> System.out.println("Run on final result"));
    }

    public void combine() {

        // chain two Futures sequentially
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
        System.out.println(completableFuture.join());

        long start = System.currentTimeMillis();
        Supplier<String> s1 = () -> {
            sleep(1000);
            return "Hello";
        };
        Supplier<String> s2 = () -> {
            sleep(3000);
            return "world ";
        };
        String result = CompletableFuture.supplyAsync(s1).thenCombine(CompletableFuture.supplyAsync(s2), (r1, r2) -> r1 + r2).join();
        System.out.println(result + " " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        result = CompletableFuture.supplyAsync(s1)
                .thenCompose(s -> CompletableFuture.supplyAsync(s2)).join();
        System.out.println(result + " " + (System.currentTimeMillis() - start));

        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> c2 = CompletableFuture.supplyAsync(() -> "World");
        CompletableFuture combine = CompletableFuture.allOf(c1, c2);
        combine.join();
        System.out.println("end of paralle computation" + c1.isDone());

        String res = Stream.of(c1, c2).map(CompletableFuture::join).collect(Collectors.joining(" "));
        System.out.println(res);

        var optResult = Optional.of("Hello").flatMap(s -> Optional.of(s.length()));
        var intResult = Optional.of("Hello").map(s -> s.length());
    }

    private void sleep(long sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            System.err.println(e.getCause());
        }
    }

    private void java9() {
        int errorCode = 1000;
        Supplier<String> supplier = () -> {sleep(1050);return "All good";};

        CompletableFuture completableFuture = CompletableFuture.supplyAsync(supplier)
                .orTimeout(1, TimeUnit.SECONDS)
                .whenComplete((String input, Throwable exception) -> {
                    if (exception != null) {
                        System.err.println("Exception error"); // Exception error
                    } else {
                        System.out.println("result: " + input);
                    }
                }).exceptionally(throwable ->
                {
                    System.out.println("recovering in exceptionally: " + throwable); // recovering in exceptionally: java.util.concurrent.CompletionException:
                    return "Recovered";
                }).thenAccept(s -> System.out.println("Final result " + s)); // Final result Recovered

        completableFuture.join();

        CompletableFuture<String> cf0 =
                CompletableFuture.failedFuture(new RuntimeException("Oops"));

        CompletableFuture cf1 =
        cf0.handle((msg, ex) -> {
            return ex != null ?  "Recovered from \"" + ex.getMessage() + "\"" : msg;
        }).thenAccept(s -> System.out.println(s)); // Recovered from Oops
        cf1.join();
    }


}
