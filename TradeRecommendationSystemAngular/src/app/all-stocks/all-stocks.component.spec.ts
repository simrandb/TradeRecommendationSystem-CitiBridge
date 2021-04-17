import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllStocksComponent } from './all-stocks.component';

describe('AllStocksComponent', () => {
  let component: AllStocksComponent;
  let fixture: ComponentFixture<AllStocksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllStocksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllStocksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
