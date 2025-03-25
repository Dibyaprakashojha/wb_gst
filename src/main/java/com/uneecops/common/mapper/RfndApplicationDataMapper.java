package com.uneecops.common.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.uneecops.common.dto.AnnexureDocumentDTO;
import com.uneecops.common.dto.BankDetailsDTO;
import com.uneecops.common.dto.DeclarationdtlsDto;
import com.uneecops.common.dto.InvertedRatedTax_Dto;
import com.uneecops.common.dto.InvoiceDet_Dto;
import com.uneecops.common.dto.ItemDto;
import com.uneecops.common.dto.NetITCDetails_Dto;
import com.uneecops.common.dto.NetItcBalancedto;
import com.uneecops.common.dto.PaymentReferenceDetail_Dto;
import com.uneecops.common.dto.ReturnDetailsDTO;
import com.uneecops.common.dto.RfdAppSuppDocumentDto;
import com.uneecops.common.dto.RfndApplicationDataDto;
import com.uneecops.common.dto.StatementDto;
import com.uneecops.common.dto.StatutoryOrderDetailsDTO;
import com.uneecops.common.entity.AnnexureDocumentDetails;
import com.uneecops.common.entity.BankDetails;
import com.uneecops.common.entity.CommonEntityForAll;
import com.uneecops.common.entity.Declarationdtls;
import com.uneecops.common.entity.InvertedRatedTax;
import com.uneecops.common.entity.InvoiceDetails;
import com.uneecops.common.entity.Items;
import com.uneecops.common.entity.NetITCBal;
import com.uneecops.common.entity.NetITCDetails;
import com.uneecops.common.entity.PaymentReferenceDetail;
import com.uneecops.common.entity.ReturnDetails;
import com.uneecops.common.entity.RfdResponse;
import com.uneecops.common.entity.RfndApplicationData;
import com.uneecops.common.entity.Statement;
import com.uneecops.common.entity.StatutoryOrderDetails;
import com.uneecops.common.entity.SuppDocumentDetails;

public class RfndApplicationDataMapper {

	public static Items mapRfndApplicationData(ItemDto itemDto, RfdResponse rfdResponse) {
		if (itemDto == null) {
			return null;
		}
		Items item = new Items();
		RfndApplicationDataDto dto = itemDto.getRfdAppData();

		RfndApplicationData appData = new RfndApplicationData();
		BeanUtils.copyProperties(dto, appData);

		appData.setDeclarationDetails(mapDeclarationDetails(dto.getDeclarationDetails(), appData, rfdResponse));

		if(dto.getReferenceClaim() != null) {
			
			if(dto.getReferenceClaim().getIgstRefClaimDet() != null) {
				appData.setIgstFee(dto.getReferenceClaim().getIgstRefClaimDet().getFee());
				appData.setIgstTax(dto.getReferenceClaim().getIgstRefClaimDet().getTax());
				appData.setIgstTot(dto.getReferenceClaim().getIgstRefClaimDet().getTot());
				appData.setIgstOthers(dto.getReferenceClaim().getIgstRefClaimDet().getOthers());
				appData.setIgstPenalty(dto.getReferenceClaim().getIgstRefClaimDet().getPenalty());
				appData.setIgstIntrest(dto.getReferenceClaim().getIgstRefClaimDet().getIntrest());
			}


			if(dto.getReferenceClaim().getCessRefClaimDet() != null) {				
				appData.setCessFee(dto.getReferenceClaim().getCessRefClaimDet().getFee());
				appData.setCessTax(dto.getReferenceClaim().getCessRefClaimDet().getTax());
				appData.setCessTot(dto.getReferenceClaim().getCessRefClaimDet().getTot());
				appData.setCessOthers(dto.getReferenceClaim().getCessRefClaimDet().getOthers());
				appData.setCessPenalty(dto.getReferenceClaim().getCessRefClaimDet().getPenalty());
				appData.setCessIntrest(dto.getReferenceClaim().getCessRefClaimDet().getIntrest());
			}
			

			if(dto.getReferenceClaim().getSgstRefClaimDet() != null) {
				appData.setSgstFee(dto.getReferenceClaim().getSgstRefClaimDet().getFee());
				appData.setSgstTax(dto.getReferenceClaim().getSgstRefClaimDet().getTax());
				appData.setSgstTot(dto.getReferenceClaim().getSgstRefClaimDet().getTot());
				appData.setSgstOthers(dto.getReferenceClaim().getSgstRefClaimDet().getOthers());
				appData.setSgstPenalty(dto.getReferenceClaim().getSgstRefClaimDet().getPenalty());
				appData.setSgstIntrest(dto.getReferenceClaim().getSgstRefClaimDet().getIntrest());

			}

			if(dto.getReferenceClaim().getCgstRefClaimDet() != null) {
				appData.setCgstFee(dto.getReferenceClaim().getCgstRefClaimDet().getFee());
				appData.setCgstTax(dto.getReferenceClaim().getCgstRefClaimDet().getTax());
				appData.setCgstTot(dto.getReferenceClaim().getCgstRefClaimDet().getTot());
				appData.setCgstOthers(dto.getReferenceClaim().getCgstRefClaimDet().getOthers());
				appData.setCgstPenalty(dto.getReferenceClaim().getCgstRefClaimDet().getPenalty());
				appData.setCgstIntrest(dto.getReferenceClaim().getCgstRefClaimDet().getIntrest());
			}
			
		}

		if(dto.getStatementSummary() != null) {
			appData.setTotalInvoiceAmount(dto.getStatementSummary().getTotalInvoiceAmount());
			appData.setInvoiceCount(dto.getStatementSummary().getInvoiceCount());
		}
		if (dto.getSupplierInfo() != null && !CollectionUtils.isEmpty(dto.getSupplierInfo().getInvoiceDtls())) {
		    appData.setInvoiceDtls(mapInvoiceDetails(dto.getSupplierInfo().getInvoiceDtls(), appData, rfdResponse));
		}


		appData.setSupportingDocuments(mapSupportingDocuments(dto.getSupportingDocuments(), appData, rfdResponse));
		appData.setStatutoryOrderDetails(
				mapStatutoryOrderDetails(dto.getStatutoryOrderDetails(), appData, rfdResponse));
		appData.setBankDetails(mapBankDetails(dto.getBankDetails(), appData, rfdResponse));
		appData.setReturnDetails(mapReturnDetails(dto.getReturnDetails(), appData, rfdResponse));
		appData.setAnnexureDocuments(mapAnnexureDocuments(dto.getAnnexureDocuments(), appData, rfdResponse));
		appData.setStatement(mapStatement(dto.getStatement(), appData, rfdResponse));

//		set gstin and crn from main CaseData Table
		appData.setCrn(rfdResponse.getCrn());
		appData.setGstin(rfdResponse.getGstin());

//		set item
		BeanUtils.copyProperties(itemDto, item);
		item.setRfdAppData(appData);
		item.setRfdResponse(rfdResponse);
		item.setCrn(rfdResponse.getCrn());
		item.setGstin(rfdResponse.getGstin());
		appData.setItems(item);

		return item;
	}

	private static Statement mapStatement(StatementDto dto, RfndApplicationData appData, RfdResponse rfdResponse) {
		if (dto == null)
			return null;
		Statement statement = new Statement();
		// Check for null before accessing nested properties
		if (dto.getAdjustedturnover() != null) {
			statement.setAdjustedturnovertax(dto.getAdjustedturnover().getTax());
		}

		if (dto.getInvertedDturnOver() != null) {
			statement.setInvertedDturnOvertax(dto.getInvertedDturnOver().getTax());
		}

		statement.setNetitc(netItcDetMapper(dto.getNetitc(), statement, rfdResponse));
		statement.setTaxpybinv(invTaxMapper(dto.getTaxpybinv(), statement, rfdResponse));

		if (dto.getZeroratedturnover() != null) {
			statement.setZeroratedturnovertax(dto.getZeroratedturnover().getTax());
		}

//		set gstin and crn from main CaseData Table
		statement.setGstin(rfdResponse.getGstin());
		statement.setCrn(rfdResponse.getCrn());

		statement.setNetITCBal(netItcBalMapper(dto.getNetITCBal(), statement, rfdResponse));
		statement.setRfndApplicationData(appData);

		return statement;
	}

	private static NetITCDetails netItcDetMapper(NetITCDetails_Dto dto, Statement statement, RfdResponse rfdResponse) {
		if (dto == null)
			return null;
		NetITCDetails details = setCommonValues(new NetITCDetails(), rfdResponse);
		details.setStatement(statement);
		BeanUtils.copyProperties(dto, details);
		return details;
	}

	private static InvertedRatedTax invTaxMapper(InvertedRatedTax_Dto dto, Statement statement,
			RfdResponse rfdResponse) {
		if (dto == null)
			return null;
		InvertedRatedTax taxpybInv = setCommonValues(new InvertedRatedTax(), rfdResponse);
		taxpybInv.setStatement(statement);
		BeanUtils.copyProperties(dto, taxpybInv);
		return taxpybInv;
	}

	private static NetITCBal netItcBalMapper(NetItcBalancedto dto, Statement statement, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		NetITCBal bal = setCommonValues(new NetITCBal(), rfdResponse);
		bal.setStatement(statement);
		BeanUtils.copyProperties(dto, bal);
		return bal;
	}

	private static Declarationdtls mapDeclarationDetails(DeclarationdtlsDto dto, RfndApplicationData appData,
			RfdResponse rfdResponse) {
		if (dto == null)
			return null;
		Declarationdtls declaration = setCommonValues(new Declarationdtls(), rfdResponse);
		BeanUtils.copyProperties(dto, declaration);
		declaration.setRfndApplicationData(appData);
		return declaration;
	}

	private static List<SuppDocumentDetails> mapSupportingDocuments(List<RfdAppSuppDocumentDto> dtoList,
			RfndApplicationData appData, RfdResponse rfdResponse) {
		if (dtoList == null)
			return Collections.emptyList();
		return dtoList.stream().map(dto -> {
			SuppDocumentDetails suppDoc = setCommonValues(new SuppDocumentDetails(), rfdResponse);
			BeanUtils.copyProperties(dto.getDocumentDetails(), suppDoc); // Copy properties from SuppDocumentDetailsDto
			suppDoc.setRfndApplicationData(appData);
			return suppDoc;
		}).collect(Collectors.toList());
	}

	private static List<InvoiceDetails> mapInvoiceDetails(List<InvoiceDet_Dto> dtoList, RfndApplicationData appData,
			RfdResponse rfdResponse) {
		return dtoList.stream().map(dto -> {
			InvoiceDetails invoice = setCommonValues(new InvoiceDetails(), rfdResponse);
			invoice.setRfndApplicationData(appData);
			BeanUtils.copyProperties(dto, invoice);
			return invoice;
		}).collect(Collectors.toList());
	}

	private static StatutoryOrderDetails mapStatutoryOrderDetails(StatutoryOrderDetailsDTO dto,
			RfndApplicationData appData, RfdResponse rfdResponse) {
		if (dto == null)
			return null;
		StatutoryOrderDetails statutoryOrder = setCommonValues(new StatutoryOrderDetails(), rfdResponse);
		BeanUtils.copyProperties(dto, statutoryOrder);
		statutoryOrder.setRfndApplicationData(appData);
		statutoryOrder.setPaymentReferenceDetails(
				mapPaymentReferenceDetails(dto.getPaymentReferenceDetail(), statutoryOrder, rfdResponse));
		return statutoryOrder;
	}

	private static List<PaymentReferenceDetail> mapPaymentReferenceDetails(List<PaymentReferenceDetail_Dto> dtoList,
			StatutoryOrderDetails statutoryOrder, RfdResponse rfdResponse) {
		if (dtoList == null)
			return Collections.emptyList();
		return dtoList.stream().map(dto -> {
			PaymentReferenceDetail paymentDetail = setCommonValues(new PaymentReferenceDetail(), rfdResponse);
			BeanUtils.copyProperties(dto, paymentDetail);
			paymentDetail.setStatutoryOrderDetails(statutoryOrder);
			return paymentDetail;
		}).collect(Collectors.toList());
	}

	private static List<BankDetails> mapBankDetails(List<BankDetailsDTO> dtoList, RfndApplicationData appData,
			RfdResponse rfdResponse) {
		if (dtoList == null)
			return Collections.emptyList();
		return dtoList.stream().map(dto -> {
			BankDetails bank = setCommonValues(new BankDetails(), rfdResponse);
			BeanUtils.copyProperties(dto, bank);
			bank.setRfndApplicationData(appData);
			return bank;
		}).collect(Collectors.toList());
	}

	private static List<ReturnDetails> mapReturnDetails(List<ReturnDetailsDTO> dtoList, RfndApplicationData appData,
			RfdResponse rfdResponse) {
		if (dtoList == null)
			return Collections.emptyList();
		return dtoList.stream().map(dto -> {
			ReturnDetails ret = setCommonValues(new ReturnDetails(), rfdResponse);
			BeanUtils.copyProperties(dto, ret);
			ret.setRfndApplicationData(appData);
			return ret;
		}).collect(Collectors.toList());
	}

	private static List<AnnexureDocumentDetails> mapAnnexureDocuments(List<AnnexureDocumentDTO> dtoList,
			RfndApplicationData appData, RfdResponse rfdResponse) {
		if (dtoList == null)
			return Collections.emptyList();
		return dtoList.stream().map(dto -> {
			AnnexureDocumentDetails annex = setCommonValues(new AnnexureDocumentDetails(), rfdResponse);
			BeanUtils.copyProperties(dto.getAnnexureDocumentDetails(), annex);
			annex.setRfndApplicationData(appData);
			return annex;
		}).collect(Collectors.toList());
	}

	private static <T extends CommonEntityForAll> T setCommonValues(T entity, RfdResponse rfdResponse) {
		entity.setGstin(rfdResponse.getGstin());
		entity.setCrn(rfdResponse.getCrn());
		return entity;
	}

}
