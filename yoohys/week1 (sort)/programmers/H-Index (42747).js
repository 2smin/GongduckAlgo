// 직접 작성한 코드
function solution(citations) {
  citations.sort((a,b)=>b-a);
  for(let i = 0; i < citations.length; i++){
    if(i === citations[i]) return i;
  }
  return citations.length;
}

// 참고받은 코드
function solution(citations) {
  citations.sort((a,b)=>b-a);
  for(let i = 0; i < citations.length; i++){
    if(i >= citations[i]) return i;
  }
  return citations.length;
}