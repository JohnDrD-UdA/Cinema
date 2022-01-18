import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingDiaglogComponent } from './booking-diaglog.component';

describe('BookingDiaglogComponent', () => {
  let component: BookingDiaglogComponent;
  let fixture: ComponentFixture<BookingDiaglogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookingDiaglogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingDiaglogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
