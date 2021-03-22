package edu.iis.mto.similarity;

import edu.iis.mto.searcher.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimilarityFinderTest {

  @Test
  void similarityFinder_should_return_1_sequences_size_0() {
    SimilarityFinder similarityFinder = new SimilarityFinder((elem, sequence) -> null);
    int[] seq = {};
    double result = similarityFinder.calculateJackardSimilarity(seq, seq);
    Assertions.assertEquals(result, 1.0d, 0.0d);
  }

  @Test
  void similarityFinder_should_return_0_first_sequence_size_1_second_size_0() {
    SearchResult build = SearchResult.builder().withFound(true).withPosition(0).build();
    SimilarityFinder similarityFinder = new SimilarityFinder((elem, sequence) -> build);
    int[] seq1 = {};
    int[] seq2 = {6178};
    double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
    Assertions.assertEquals(result, 0.0d, 0.0d);
  }

  @Test
  void similarityFinder_should_return_0_first_sequence_size_0_second_size_1() {
    SearchResult build = SearchResult.builder().withFound(false).withPosition(0).build();
    SimilarityFinder similarityFinder = new SimilarityFinder((elem, sequence) -> build);
    int[] seq1 = {};
    int[] seq2 = {6178};
    double result = similarityFinder.calculateJackardSimilarity(seq2, seq1);
    Assertions.assertEquals(result, 0.0d, 0.0d);
  }

    @Test
    void similarityFinder_should_return_1_when_sequence_are_the_same () {
        SearchResult build = SearchResult.builder().withFound(true).withPosition(0).build();
        SimilarityFinder similarityFinder = new SimilarityFinder((elem, sequence) -> build);
        int[] seq = {1,2,3};
        double result = similarityFinder.calculateJackardSimilarity(seq, seq);
        Assertions.assertEquals(result, 1.0d, 0.0d);
    }

    @Test
    void similarityFinder_should_return_0_5_when_one_sequence_contains_other () {
        SearchResult build = SearchResult.builder().withFound(true).withPosition(0).build();
        SimilarityFinder similarityFinder = new SimilarityFinder((elem, sequence) -> build);
        int[] seq1 = {1,2,3,4,5,6};
        int[] seq2 = {1,2,3};
        double result = similarityFinder.calculateJackardSimilarity(seq2, seq1);
        Assertions.assertEquals(result, 0.5d, 0.0d);
    }


}
