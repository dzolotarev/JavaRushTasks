package com.javarush.task.task19.task1918;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution2 {

    public static void main(String[] args) {

        String tag = "span";
        String input = "Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela</span></b></span><span>Super</span><span>girl</span>";
        extractTags(input,tag);


    }

    public static void extractTags(String input, String tag) {
        String openTag = "<" + tag;
        String closeTag = "</" + tag + ">";

        LinkedList<TagPosition> stack = new LinkedList<>();
        ArrayList<TagPosition> foundTags = new ArrayList<>();

        int position = 0;
        while (position < input.length()) {
            char current = input.charAt(position);
            if (current == '<') {
                if (isOpenTag(input, openTag, position)) {
                    stack.push(new TagPosition(position));
                    position += openTag.length();
                } else if (isCloseTag(input, closeTag, position)) {
                    TagPosition tagPosition = stack.pop();
                    position += closeTag.length();
                    tagPosition.endPosition = position;
                    foundTags.add(tagPosition);
                } else {
                    position++;
                }
            } else {
                position++;
            }
        }

        Collections.sort(foundTags, Comparator.comparingInt(o -> o.startPosition));

        for (TagPosition foundTag : foundTags) {
            System.out.println(input.substring(foundTag.startPosition, foundTag.endPosition));
        }
    }

    private static boolean isOpenTag(String input, String openTag, int position) {
        int endPosition = position + openTag.length();
        if (endPosition >= input.length()) {
            return false;
        } else {
            String candidate = input.substring(position, endPosition);
            return candidate.equals(openTag) && isValidStartTagEnding(input.charAt(endPosition));
        }
    }

    private static boolean isValidStartTagEnding(char ch) {
        return ch == ' ' || ch == '>' || ch == '\n' || ch == '\r';
    }

    private static boolean isCloseTag(String input, String closeTag, int position) {
        int endPosition = position + closeTag.length();
        if (endPosition > input.length()) {
            return false;
        } else {
            return input.substring(position, endPosition).equals(closeTag);
        }
    }

    private static class TagPosition {
        public int startPosition;
        public int endPosition;

        public TagPosition(int startPosition) {
            this.startPosition = startPosition;
        }
    }

}
