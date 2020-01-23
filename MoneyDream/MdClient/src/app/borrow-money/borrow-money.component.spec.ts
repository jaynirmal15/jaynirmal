import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BorrowMoneyComponent } from './borrow-money.component';

describe('BorrowMoneyComponent', () => {
  let component: BorrowMoneyComponent;
  let fixture: ComponentFixture<BorrowMoneyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BorrowMoneyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BorrowMoneyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
