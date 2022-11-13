package io.gig.coffeechat.domain.factory;

import io.gig.coffeechat.domain.member.Member;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.range.LongRangeRandomizer;

import static org.jeasy.random.FieldPredicates.named;

/**
 * @author : JAKE
 * @date : 2022/11/13
 * https://github.com/j-easy/easy-random
 */
public class MemberFixtureFactory {

    static public Member create() {
        var params = new EasyRandomParameters()
                .excludeField(named("id"))
                .stringLengthRange(1, 10)
                .randomize(Long.class, new LongRangeRandomizer(1L, 100L));
        return new EasyRandom(params).nextObject(Member.class);
    }
}
