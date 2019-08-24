import ServerAPI from '@/services/ServerAPI.js';

export default {
  getVisitCount() {
    return ServerAPI.getConnection().get('/counter');
  }
};
