/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hellojavaer.ddr.core.shard.simple;

import org.hellojavaer.ddr.core.datasource.jdbc.SQLParsedResult;
import org.hellojavaer.ddr.core.shard.ShardParser;
import org.hellojavaer.ddr.core.shard.ShardRouter;
import org.hellojavaer.ddr.core.sqlparse.SqlParser;

import java.util.Map;

/**
 *
 * @author <a href="mailto:hellojavaer@gmail.com">Kaiming Zou</a>,created on 15/11/2016.
 */
public class SimpleShardParser implements ShardParser {

    private ShardRouter shardRouter = null;
    private SqlParser   sqlParser   = null;

    public ShardRouter getShardRouter() {
        return shardRouter;
    }

    public void setShardRouter(ShardRouter shardRouter) {
        this.shardRouter = shardRouter;
    }

    public SqlParser getSqlParser() {
        return sqlParser;
    }

    public void setSqlParser(SqlParser sqlParser) {
        this.sqlParser = sqlParser;
    }

    @Override
    public SQLParsedResult parse(String sql, Map<Object, Object> jdbcParams) {
        return sqlParser.parse(sql, jdbcParams, shardRouter);
    }
}
