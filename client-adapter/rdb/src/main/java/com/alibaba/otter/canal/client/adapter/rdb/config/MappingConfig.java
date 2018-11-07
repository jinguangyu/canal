package com.alibaba.otter.canal.client.adapter.rdb.config;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * RDB表映射配置
 *
 * @author rewerma 2018-11-07 下午02:41:34
 * @version 1.0.0
 */
public class MappingConfig {

    private String    dataSourceKey; // 数据源key

    private String    destination;   // canal实例或MQ的topic

    private DbMapping dbMapping;     // db映射配置

    public String getDataSourceKey() {
        return dataSourceKey;
    }

    public void setDataSourceKey(String dataSourceKey) {
        this.dataSourceKey = dataSourceKey;
    }

    public DbMapping getDbMapping() {
        return dbMapping;
    }

    public void setDbMapping(DbMapping dbMapping) {
        this.dbMapping = dbMapping;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void validate() {
        if (dbMapping.database == null || dbMapping.database.isEmpty()) {
            throw new NullPointerException("dbMapping.database");
        }
        if (dbMapping.table == null || dbMapping.table.isEmpty()) {
            throw new NullPointerException("dbMapping.table");
        }
        if (dbMapping.targetTable == null || dbMapping.targetTable.isEmpty()) {
            throw new NullPointerException("dbMapping.targetTable");
        }
    }

    public static class DbMapping {

        private String              database;                            // 数据库名或schema名
        private String              table;                               // 表面名
        private boolean             mapAll      = false;                 // 映射所有字段
        private String              targetTable;                         // 目标表名
        private Map<String, String> targetColums;                        // 目标表字段映射
        private String              etlCondition;                        // etl条件sql

        private Set<String>         families    = new LinkedHashSet<>(); // column family列表
        private int                 readBatch   = 5000;
        private int                 commitBatch = 5000;                  // etl等批量提交大小

        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }

        public String getTable() {
            return table;
        }

        public void setTable(String table) {
            this.table = table;
        }

        public boolean isMapAll() {
            return mapAll;
        }

        public void setMapAll(boolean mapAll) {
            this.mapAll = mapAll;
        }

        public String getTargetTable() {
            return targetTable;
        }

        public void setTargetTable(String targetTable) {
            this.targetTable = targetTable;
        }

        public Map<String, String> getTargetColums() {
            return targetColums;
        }

        public void setTargetColums(Map<String, String> targetColums) {
            this.targetColums = targetColums;
        }

        public String getEtlCondition() {
            return etlCondition;
        }

        public void setEtlCondition(String etlCondition) {
            this.etlCondition = etlCondition;
        }

        public Set<String> getFamilies() {
            return families;
        }

        public void setFamilies(Set<String> families) {
            this.families = families;
        }

        public int getReadBatch() {
            return readBatch;
        }

        public void setReadBatch(int readBatch) {
            this.readBatch = readBatch;
        }

        public int getCommitBatch() {
            return commitBatch;
        }

        public void setCommitBatch(int commitBatch) {
            this.commitBatch = commitBatch;
        }
    }
}
