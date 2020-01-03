package com.david.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPActionIsNull() {
            addCriterion("p_action is null");
            return (Criteria) this;
        }

        public Criteria andPActionIsNotNull() {
            addCriterion("p_action is not null");
            return (Criteria) this;
        }

        public Criteria andPActionEqualTo(String value) {
            addCriterion("p_action =", value, "pAction");
            return (Criteria) this;
        }

        public Criteria andPActionNotEqualTo(String value) {
            addCriterion("p_action <>", value, "pAction");
            return (Criteria) this;
        }

        public Criteria andPActionGreaterThan(String value) {
            addCriterion("p_action >", value, "pAction");
            return (Criteria) this;
        }

        public Criteria andPActionGreaterThanOrEqualTo(String value) {
            addCriterion("p_action >=", value, "pAction");
            return (Criteria) this;
        }

        public Criteria andPActionLessThan(String value) {
            addCriterion("p_action <", value, "pAction");
            return (Criteria) this;
        }

        public Criteria andPActionLessThanOrEqualTo(String value) {
            addCriterion("p_action <=", value, "pAction");
            return (Criteria) this;
        }

        public Criteria andPActionLike(String value) {
            addCriterion("p_action like", value, "pAction");
            return (Criteria) this;
        }

        public Criteria andPActionNotLike(String value) {
            addCriterion("p_action not like", value, "pAction");
            return (Criteria) this;
        }

        public Criteria andPActionIn(List<String> values) {
            addCriterion("p_action in", values, "pAction");
            return (Criteria) this;
        }

        public Criteria andPActionNotIn(List<String> values) {
            addCriterion("p_action not in", values, "pAction");
            return (Criteria) this;
        }

        public Criteria andPActionBetween(String value1, String value2) {
            addCriterion("p_action between", value1, value2, "pAction");
            return (Criteria) this;
        }

        public Criteria andPActionNotBetween(String value1, String value2) {
            addCriterion("p_action not between", value1, value2, "pAction");
            return (Criteria) this;
        }

        public Criteria andPInfoIsNull() {
            addCriterion("p_info is null");
            return (Criteria) this;
        }

        public Criteria andPInfoIsNotNull() {
            addCriterion("p_info is not null");
            return (Criteria) this;
        }

        public Criteria andPInfoEqualTo(String value) {
            addCriterion("p_info =", value, "pInfo");
            return (Criteria) this;
        }

        public Criteria andPInfoNotEqualTo(String value) {
            addCriterion("p_info <>", value, "pInfo");
            return (Criteria) this;
        }

        public Criteria andPInfoGreaterThan(String value) {
            addCriterion("p_info >", value, "pInfo");
            return (Criteria) this;
        }

        public Criteria andPInfoGreaterThanOrEqualTo(String value) {
            addCriterion("p_info >=", value, "pInfo");
            return (Criteria) this;
        }

        public Criteria andPInfoLessThan(String value) {
            addCriterion("p_info <", value, "pInfo");
            return (Criteria) this;
        }

        public Criteria andPInfoLessThanOrEqualTo(String value) {
            addCriterion("p_info <=", value, "pInfo");
            return (Criteria) this;
        }

        public Criteria andPInfoLike(String value) {
            addCriterion("p_info like", value, "pInfo");
            return (Criteria) this;
        }

        public Criteria andPInfoNotLike(String value) {
            addCriterion("p_info not like", value, "pInfo");
            return (Criteria) this;
        }

        public Criteria andPInfoIn(List<String> values) {
            addCriterion("p_info in", values, "pInfo");
            return (Criteria) this;
        }

        public Criteria andPInfoNotIn(List<String> values) {
            addCriterion("p_info not in", values, "pInfo");
            return (Criteria) this;
        }

        public Criteria andPInfoBetween(String value1, String value2) {
            addCriterion("p_info between", value1, value2, "pInfo");
            return (Criteria) this;
        }

        public Criteria andPInfoNotBetween(String value1, String value2) {
            addCriterion("p_info not between", value1, value2, "pInfo");
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