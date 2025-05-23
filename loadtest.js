import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  stages: [
    { duration: '5m', target: 100 }, // traffic ramp-up from 1 to 100 users over 5 minutes.
    { duration: '5m', target: 100 }, // stay at 100 users for 5 minutes
  ]
};

export default () => {
  const url = 'http://48.217.17.5:80';

  let i = 0
  let formData = JSON.stringify({ "description": "test" });
  let headers = { 'Content-Type': 'application/json' };

  http.post(url + '/todo', formData, { headers: headers });
  sleep(1);
  http.get(url + '/todo/' + i++);
  sleep(1);
  http.get(url + '/todo/all');
  sleep(1);
};