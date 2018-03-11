import { Component, OnInit } from '@angular/core';
import { IncomeCathegory, ExpenseCathegory } from '../../../Domains/app-interfaces';
import { isNumber } from 'util';
import { TransactionService } from '../../../Services/transaction-service';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-transaction-add',
  templateUrl: './transaction-add.component.html',
  styleUrls: ['./transaction-add.component.css']
})
export class TransactionAddComponent implements OnInit {
  private incomeFlag = true;
  private expenseFlag = false;
  private info: string;
  private amount: number;
  private cathegory: any;
  private date: Date;
  private modelDate: NgbDateStruct;

  private incomeCathegory: string[];
  private expenseCathegory: string[];
  private cathegoryView: string[];

  constructor(private transactionService: TransactionService) { }

  ngOnInit() {
    this.initiation();
  }

  initiation() {
    this.date = new Date();
    this.incomeCathegory = new Array();
    for(let cath in IncomeCathegory){
      if(isNaN(parseInt(cath))){
      this.incomeCathegory.push(cath);
      }
    }

    this.expenseCathegory = new Array();
    for(let cath in ExpenseCathegory){
      if(isNaN(parseInt(cath))){
      this.expenseCathegory.push(cath);
      }
    }
    this.cathegoryView = this.incomeCathegory;
  }

  onAdd() {
    if(this.incomeFlag){
     /// this.transactionService.addIncome()
    }else {
      // this.transactionService.
    }
  }

  onDateChange() {
    this.date = new Date(
      this.modelDate.year, this.modelDate.month-1, this.modelDate.day
    );
  }

  onChange(event, event2) {
   console.log(event);
   console.log(event2);
  }

  onRadioButtonClick(event){
    if(event.id == "customRadioInline1"){
      this.incomeFlag = true;
      this.expenseFlag = false;
      this.cathegoryView = this.incomeCathegory;
    }else {
      this.incomeFlag = false;
      this.expenseFlag = true;
      this.cathegoryView = this.expenseCathegory;
    }
  }
}
