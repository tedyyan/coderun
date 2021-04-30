'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    
});

function readLine() {
    return inputString[currentLine++];
}

//console.log(getTotalGoals("Barcelona",1));

/*
 * Complete the 'getTotalGoals' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING team
 *  2. INTEGER year
 */

function getPromise() {
    return new Promise((resolve, reject) => {

        const https = require('https');
        https.get('https://jsonmock.hackerrank.com/api/football_matches?year=2011&team1=Barcelona&page=1', (resp) => {
        let data = '';
        let jsonb = '';
        // A chunk of data has been received.
        resp.on('data', (chunk) => {
            data += chunk;
        });

        // The whole response has been received. Print out the result.
        resp.on('end', () => {
            jsonb = JSON.parse(data);
            let total = jsonb.total_pages;
            //console.log(jsonb);
            resolve(total)
        });

        }).on("error", (err) => {
        console.log("Error: " + err.message);
        });
    });
}

(async function () {
    // wait to http request to finish
    let value1 = await getTotalGoals("Barcelona",2011);
    // below code will be executed after http request is finished
    console.log(value1);
})();


async function getTotalGoals(team, year) {

    
    // promise resolved or rejected asynchronously
    let http_promise = getPromise();
	let total = await http_promise;

    let suma = 0;
    let i = 0;
    console.log("total:"+total);
    
    
        const https = require('https');
        let ans = 0;
        for (i=0;i<total; i++){
            let newk = new Promise((resolve, reject) => {
                https.get('https://jsonmock.hackerrank.com/api/football_matches?year=2011&team1='+team+'&page=' + i, (resp2) => {

                    let data2 = '';
                    resp2.on('data', (chunk2) => {
                        data2 += chunk2;
                    });
                    resp2.on('end', () => {
                        suma = getCnt(data2);
                        resolve(suma);
                    })
                });
            });
            ans += await newk;
        }

    return ans;
}
function getCnt(data) {
    let arr = JSON.parse(data).data;
    let ans = 0;
    let j = 0;
    for (j=0;j<arr.length;j++){
        ans += parseInt(arr[j]["team1goals"])
    }
    return ans;
}
async function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const team = readLine();

    const year = parseInt(readLine().trim(), 10);

    const result = await getTotalGoals(team, year);

    ws.write(result + '\n');

    ws.end();
}
