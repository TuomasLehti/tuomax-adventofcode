package fi.tuomax.adventofcode.year2015.day08;

/**
 * <p>Counts the length of a string.</p>
 *
 * <p>The naming of the strings can be a bit misleading. String literal is
 * the representation of a string in a medium, eg disk. Each character in
 * this string represents a byte in the literal string. Any reference to a
 * string in memory means the decoded string.<p>
 * 
 * <p>For example a string literal is \x27, which takes up one byte in
 * memory.</p>
 */
public class SantaString {

    /**
     * <p>Counts the amount of bytes needed for storing a string literal in 
     * memory.</p>
     * 
     */
    public static Integer charsInMemory(String literal)
    {
        /* 
         * The monstrosity of these regexes is off the chart. 
         *
         * The first one is in effect \\\\|\\"|\\x\w{2}, but the backslashes
         * have to be escaped out by a backslash.
         * 
         * -- \\\\ matches two backslashes. They have to be escaped out by a
         *    backslash here too! \\ in the literal string boils down to a 
         *    single backslash in memory.
         * -- \\" matches a backslash and a quite. \" in the literal string
         *    boils down to a single quote character in memory.
         * -- \\x\w{2} matches a backslash, the letter x and two digits.
         *    \x27 represents a an apostrophe in hexadecimal form. A single
         *    character in memory results.
         * 
         * All the escaped sequences in the string literal represent a single
         * character in memory, which is why they are replaced a question
         * mark. This could be any character we like, since we only care about
         * the length of the string.
         * 
         * The second regex is much more simple. All it does is remove the
         * first and last quote, which will not count towards the length of
         * the string in memory.
         */
        String memory = literal;
        memory = memory.replaceAll("\\\\\\\\|\\\\\"|\\\\x\\w{2}", "?");
        memory = memory.replaceAll("\"", "");
        return memory.length();
    }

    /**
     * <p>Counts the amount of bytes needed for storing a string in a medium
     * in the literal form.</p>
     */
    public static Integer charsInLiteral(String memory) 
    {
        /* The second part is simple in comparison to the first. 
         * 
         * The length of the encoded string is at least two, because it always
         * starts and ends with a quote character.
         * 
         * Each character in memory represents a character in the literal 
         * string. If the character in memory happens to be a character, whici
         * needs to be escaped, the length of the literal string grows by one.
         * 
         * There is no need to encode anything into the hexadecimal form.
        */
        Integer answer = 2;
        for (char c : memory.toCharArray()) {
            answer++;
            if (c == '\\' || c == '"') answer++;
        }
        return answer;
    }
    
}
