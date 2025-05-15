import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  // Key configurations for avg load test in this section
  stages: [
    { duration: '5m', target: 100 }, // traffic ramp-up from 1 to 100 users over 5 minutes.
    { duration: '10m', target: 100 }, // stay at 100 users for 5 minutes
    { duration: '2m', target: 0 }, // ramp-down to 0 users
  ],
};

export default () => {
  const url = 'http://48.216.175.205:80';

  let i = 1
  let formData = JSON.stringify({ "description": "Hallo" });
  let headers = { 'Content-Type': 'application/json' };

  http.post(url + '/todo', formData, { headers: headers });
  http.get(url + '/todo/' + i++);
  http.get(url + '/todo/all');
  sleep(1);
};