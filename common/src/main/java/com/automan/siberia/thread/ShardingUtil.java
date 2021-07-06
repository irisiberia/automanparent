package com.automan.siberia.thread;

/**
 * @author he.zhou
 * @date 2020/1/2
 **/
public class ShardingUtil {

    private static InheritableThreadLocal<ShardingVO> contextHolder = new InheritableThreadLocal<>();

    public static class ShardingVO {
        private int index;

        private int total;

        public ShardingVO(int index, int total) {
            this.index = index;
            this.total = total;
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getTotal() {
            return this.total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    public static void setShardingVo(ShardingVO shardingVo) {
        contextHolder.set(shardingVo);
    }

    public static ShardingVO getShardingVo() {
        return contextHolder.get();
    }

    public static void main(String[] args) {
        System.out.println(ShardingUtil.getShardingVo().total);
    }
}
