//package org.allenai.taggers.tag;
//
//import java.io.File;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Scanner;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.jdom2.Document;
//import org.jdom2.Element;
//import org.jdom2.JDOMException;
//import org.jdom2.input.SAXBuilder;
//
//import com.google.common.collect.Iterables;
//
//import org.allenai.nlpstack.chunk.ChunkedToken;
//import org.allenai.nlpstack.chunk.OpenNlpChunker;
//import org.allenai.nlpstack.lemmatize.Lemmatized;
//import org.allenai.nlpstack.lemmatize.MorphaStemmer;
//import org.allenai.taggers.SentenceFunctions;
//import org.allenai.nlpstack.typer.Type;
//
///***
// * A collection of {@see Tagger}s.
// * @author schmmd
// *
// */
//public class TaggerCollection {
//    private static final Logger logger = LoggerFactory.getLogger(TaggerCollection.class);
//
//    private final List<Tagger> taggers;
//
//    public TaggerCollection() {
//        this(Collections.<Tagger> emptyList());
//    }
//
//    public TaggerCollection(Collection<Tagger> taggers) {
//        this.taggers = new ArrayList<Tagger>(taggers);
//    }
//
//    public TaggerCollection(Tagger tagger) {
//        this(Arrays.asList(new Tagger[] {tagger}));
//    }
//
//    @Override
//    public String toString() {
//        return this.taggers.toString();
//    }
//
//    @Override
//    public boolean equals(Object that) {
//        if (that == null) return false;
//        if (this == that) return true;
//        if (this.getClass() != that.getClass()) return false;
//
//        TaggerCollection col = (TaggerCollection)that;
//        return Iterables.elementsEqual(taggers, col.taggers);
//    }
//
//    public void addTagger(Tagger tagger) {
//        this.taggers.add(tagger);
//    }
//
//    public List<Type> tag(scala.collection.Seq<Lemmatized<ChunkedToken>> sentence) {
//        ArrayList<Type> list = new ArrayList<Type>();
//        for (Tagger tagger : taggers) {
//            list.addAll(tagger.findTagsWithTypes(sentence,scala.collection.immutable.Seq.<Type>empty(list)));
//        }
//
//        return list;
//    }
//
//    /*
//    public static void main(String[] args) throws SecurityException, IllegalArgumentException, JDOMException, IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
//        TaggerCollection taggers = TaggerCollection.fromPath(args[0]);
//
//        OpenNlpChunker chunker = new OpenNlpChunker();
//
//        System.out.println("Please enter a sentence to tag:");
//
//        MorphaStemmer morpha = new MorphaStemmer();
//
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//
//            List<ChunkedToken> chunkedSentence = scala.collection.JavaConverters.seqAsJavaListConverter(chunker.chunk(line)).asJava();
//            List<Lemmatized<ChunkedToken>> tokens = new ArrayList<Lemmatized<ChunkedToken>>(chunkedSentence.size());
//            for (ChunkedToken token : chunkedSentence) {
//                Lemmatized<ChunkedToken> lemma = morpha.lemmatizeToken(token);
//                tokens.add(lemma);
//            }
//
//            System.out.println(SentenceFunctions.text(tokens));
//
//            List<Type> types = taggers.tag(tokens);
//            for (Type type : types) {
//                System.out.println(type);
//            }
//        }
//        scanner.close();
//    }
//    */
//}
