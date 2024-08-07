package fi.tuomax.adventofcode.year2016.day14;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.MD5;

public class Test_MD5Iterations
{

    @Test
    public void test()
    {
        String hash;

        hash = MD5.getMD5("abc0", 1);
        assertEquals("577571be4de9dcce85a041ba0410f29f", hash);

        hash = MD5.getMD5("abc0", 2);
        assertEquals("eec80a0c92dc8a0777c619d9bb51e910", hash);

        hash = MD5.getMD5("abc0", 3);
        assertEquals("16062ce768787384c81fe17a7a60c7e3", hash);

        hash = MD5.getMD5("abc0", 2017);
        assertEquals("a107ff634856bb300138cac6568c0f24", hash);
    }
    
}
