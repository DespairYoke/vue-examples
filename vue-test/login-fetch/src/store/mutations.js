import {
    RECORD_USERINFO,
    GET_USERINFO,
} from './mutation-types.js'

import {setStore} from '../config/mUtils'
export default {
    [RECORD_USERINFO](state,info) {
        state.userInfo = info;
        state.login = true;
        setStore('phone',info.phone);
    },
    [GET_USERINFO](state, info) {
		if (state.userInfo && (state.userInfo.username !== info.username)) {
			return;
		};
		if (!state.login) {
			return
		}
		if (!info.message) {
			state.userInfo = {...info};
		} else {
			state.userInfo = null;
		}
	},
}