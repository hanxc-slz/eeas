package com.imnu.eeas.pojo.exemple;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CensusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CensusExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andCountAllIsNull() {
            addCriterion("count_all is null");
            return (Criteria) this;
        }

        public Criteria andCountAllIsNotNull() {
            addCriterion("count_all is not null");
            return (Criteria) this;
        }

        public Criteria andCountAllEqualTo(Double value) {
            addCriterion("count_all =", value, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllNotEqualTo(Double value) {
            addCriterion("count_all <>", value, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllGreaterThan(Double value) {
            addCriterion("count_all >", value, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllGreaterThanOrEqualTo(Double value) {
            addCriterion("count_all >=", value, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllLessThan(Double value) {
            addCriterion("count_all <", value, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllLessThanOrEqualTo(Double value) {
            addCriterion("count_all <=", value, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllIn(List<Double> values) {
            addCriterion("count_all in", values, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllNotIn(List<Double> values) {
            addCriterion("count_all not in", values, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllBetween(Double value1, Double value2) {
            addCriterion("count_all between", value1, value2, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllNotBetween(Double value1, Double value2) {
            addCriterion("count_all not between", value1, value2, "countAll");
            return (Criteria) this;
        }

        public Criteria andFrontDateIsNull() {
            addCriterion("front_date is null");
            return (Criteria) this;
        }

        public Criteria andFrontDateIsNotNull() {
            addCriterion("front_date is not null");
            return (Criteria) this;
        }

        public Criteria andFrontDateEqualTo(Date value) {
            addCriterionForJDBCDate("front_date =", value, "frontDate");
            return (Criteria) this;
        }

        public Criteria andFrontDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("front_date <>", value, "frontDate");
            return (Criteria) this;
        }

        public Criteria andFrontDateGreaterThan(Date value) {
            addCriterionForJDBCDate("front_date >", value, "frontDate");
            return (Criteria) this;
        }

        public Criteria andFrontDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("front_date >=", value, "frontDate");
            return (Criteria) this;
        }

        public Criteria andFrontDateLessThan(Date value) {
            addCriterionForJDBCDate("front_date <", value, "frontDate");
            return (Criteria) this;
        }

        public Criteria andFrontDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("front_date <=", value, "frontDate");
            return (Criteria) this;
        }

        public Criteria andFrontDateIn(List<Date> values) {
            addCriterionForJDBCDate("front_date in", values, "frontDate");
            return (Criteria) this;
        }

        public Criteria andFrontDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("front_date not in", values, "frontDate");
            return (Criteria) this;
        }

        public Criteria andFrontDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("front_date between", value1, value2, "frontDate");
            return (Criteria) this;
        }

        public Criteria andFrontDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("front_date not between", value1, value2, "frontDate");
            return (Criteria) this;
        }

        public Criteria andAfterDateIsNull() {
            addCriterion("after_date is null");
            return (Criteria) this;
        }

        public Criteria andAfterDateIsNotNull() {
            addCriterion("after_date is not null");
            return (Criteria) this;
        }

        public Criteria andAfterDateEqualTo(Date value) {
            addCriterionForJDBCDate("after_date =", value, "afterDate");
            return (Criteria) this;
        }

        public Criteria andAfterDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("after_date <>", value, "afterDate");
            return (Criteria) this;
        }

        public Criteria andAfterDateGreaterThan(Date value) {
            addCriterionForJDBCDate("after_date >", value, "afterDate");
            return (Criteria) this;
        }

        public Criteria andAfterDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("after_date >=", value, "afterDate");
            return (Criteria) this;
        }

        public Criteria andAfterDateLessThan(Date value) {
            addCriterionForJDBCDate("after_date <", value, "afterDate");
            return (Criteria) this;
        }

        public Criteria andAfterDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("after_date <=", value, "afterDate");
            return (Criteria) this;
        }

        public Criteria andAfterDateIn(List<Date> values) {
            addCriterionForJDBCDate("after_date in", values, "afterDate");
            return (Criteria) this;
        }

        public Criteria andAfterDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("after_date not in", values, "afterDate");
            return (Criteria) this;
        }

        public Criteria andAfterDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("after_date between", value1, value2, "afterDate");
            return (Criteria) this;
        }

        public Criteria andAfterDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("after_date not between", value1, value2, "afterDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
