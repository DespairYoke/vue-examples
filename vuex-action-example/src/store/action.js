import {ADD_AGE} from './mutation-types'

export default {
    [ADD_AGE](state,age) {
        console.log(age,1111)
        state.age = age
    }
}