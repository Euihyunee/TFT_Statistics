// 팩토리패턴
// 1. 새로운 오브젝트를 생성(위임), 이후 리턴
// 2. 속성, 매개함수를 공유하는 다른 타입의 오브젝트 생성

class Shoe {
    constructor(attrs) {
        this._attrs = attrs || {};
    }
    // 속성값 리턴하는 함수
    getName() {
        return this._attrs?.name;
    }
    getSize() {
        return this._attrs?.size;
    }
    getBrand() {
        return this.constructor.name;
    }
}

// 브랜드를 대표하는 공정
// 3개의 클래스 모두 Shoe를 상속받음
class Nike extends Shoe {}
class Puma extends Shoe {}
class Adidas extends Shoe {}

// test용 정보 저장
const data = [
    // type이라는 속성값을 기준으로 factory가 움직임
    // 세부 속성 저장됨
    { type: 'Nike', attrs: { name: 'SB', size: 300 } },
    { type: 'Nike', attrs: { name: 'Airforce', size: 240 } },
    { type: 'Puma', attrs: { name: 'Jada', size: 270 } },
    { type: 'Nike', attrs: { name: 'Cortez', size: 265 } },
    { type: 'Adidas', attrs: { name: 'Super Star', size: 290 } },
];

// factory 클래스
class ShoeFactory {
    // 속성값들이 래퍼런스들을 hold하고 있음
    typeMap = {
        nike: Nike,
        puma: Puma,
        adidas: Adidas,
    };
    create(props) {
        try {
            // 어떤 타입의 클래스를 생성할지 선택한 후
            // Brand에 저장한 후 리턴
            const Brand = this.typeMap[props?.type?.toLowerCase()];
            return new Brand(props.attrs);
        } catch (e) {
            console.log('error creating new shoes', e);
        }
    }
}

const factory = new ShoeFactory();
const nike1 = factory.create({
    type: 'Nike',
    attrs: { name: 'Cortez', size: 265 },
});

console.log(nike1);
console.log(nike1.getBrand());
console.log(nike1.getSize());
console.log(nike1.getName());

// js에서 map 함수와 종종 사용이 됨
// map을 통한 테스트

const items = data.map((item) => factory.create(item));
console.log(items);
//[Nike, Nike, Puma, Nike, Adidas]