import {UPDATE_SEX,ADD_AGE} from './mutation-types'

export default {
    [UPDATE_SEX](state, sex) {
        state.sex = sex;
    },
    [ADD_AGE](state,age) {
        console.log(age,1111)
        state.age = age
    }
}