SELECT AVG(
               CASE
                   WHEN r1.type = 'RequestSent' AND r2.type = 'RequestReceived' THEN EXTRACT(EPOCH FROM (r2.datetime - r1.datetime)) * 1000
                   WHEN r1.type = 'ResponceSent' AND r2.type = 'ResponceReceived' THEN EXTRACT(EPOCH FROM (r2.datetime - r1.datetime)) * 1000
                   ELSE 0
                   END
           ) AS avg_network_time_ms
FROM request r1
         JOIN request r2 ON r1.request_id = r2.parent_request_id
WHERE r1.parent_request_id IS NULL